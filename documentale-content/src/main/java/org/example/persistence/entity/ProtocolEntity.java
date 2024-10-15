package org.example.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "protocol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProtocolEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String validationUser;
    private Boolean isValid;
    private String type;
    private String state;

}