package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DocToArchiveDTO {

    private Long documentId;
    private LocalDate archiveDate;
    private Long archiveUserId;

}
