package org.example.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String refNumber;
    private String owner;
    private String type;
    private String state;
    private String location;
    private LocalDate docDate;
    private ProtocolEntity protocol;

}