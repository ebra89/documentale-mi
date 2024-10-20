package org.example.service.dtos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class DocConfigDto {

    private Long id;
    private List<String> docType;
    private Long size;
    private String path;
    private String department;
}
