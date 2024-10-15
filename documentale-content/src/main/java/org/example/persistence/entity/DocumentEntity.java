package org.example.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentEntity extends BaseEntity {

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


    @ManyToOne(targetEntity = ProtocolEntity.class)
    @JoinColumn(name = "protocolId")
    //    @JsonBackReference
    private ProtocolEntity protocol;

}