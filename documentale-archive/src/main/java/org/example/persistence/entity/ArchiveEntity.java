package org.example.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "archive")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArchiveEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "document_id")
    private Long documentId;
    private String archiveUserId; // email
    private String state;
    private String location;
    private LocalDate archiveDate;

}