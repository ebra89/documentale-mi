package org.example.config;

import org.example.exception.CustomAccessDeniedHandler;
import org.example.utils.KeycloakRoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    /*@Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
    String introspectionUri;
    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
    String clientId;
    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
    String clientSecret;*/

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http
            // No session managed by Spring
            .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // CORS config
            .cors(cors -> cors.configurationSource(corsConfigurationSource))

            // CSRF management
            .csrf(csrfConfig -> csrfConfig.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/**")))

            // Request authorizations
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(AntPathRequestMatcher.antMatcher("/test")).hasRole("USER")
                //                .requestMatchers("/api-1").hasAnyRole("USER", "ADMIN")
                //                .requestMatchers("/api-2").authenticated()
                //                .requestMatchers("/api-3").hasRole("USER")
                //                .requestMatchers("/api-4").authenticated()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .anyRequest().authenticated()
            )

            // JWT-based requests config
            .oauth2ResourceServer(rsc -> rsc.jwt(jwtConfigurer ->
                jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter)))
            // http.oauth2ResourceServer(rsc -> rsc.opaqueToken(otc -> otc.authenticationConverter(new KeycloakOpaqueRoleConverter())
            //   .introspectionUri(this.introspectionUri).introspectionClientCredentials(this.clientId,this.clientSecret)));

            // Exception handling
            .exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        configuration.setExposedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}