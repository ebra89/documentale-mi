package org.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProtocolEntity extends BaseEntity {

    private Long id;
    private String validationUser;
    private Boolean isValid;
    private String type;
    private String state;

}