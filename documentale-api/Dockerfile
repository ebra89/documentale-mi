FROM openjdk:17-alpine
EXPOSE 8090
RUN apk add --no-cache bash && apk --no-cache add curl
RUN addgroup -g 2000 -S spring && adduser -G spring -S -u 2000 spring
RUN mkdir -p /var/log/app/ && mkdir -p /usr/local/app && chown spring:spring /var/log/app/
COPY /target/*.jar /usr/local/app/application.jar
WORKDIR /usr/local/app
USER spring:spring
ENTRYPOINT ["java", "-jar", "application.jar"]