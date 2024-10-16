package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BaseEntity {

    private LocalDateTime createDate; // create_date
    private String createUser;
    private LocalDateTime updateDate;
    private String updateUser;

}