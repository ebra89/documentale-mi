package org.example.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate; // create_date

    @CreatedBy
    @Column(updatable = false)
    private String createUser;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updateDate;

    @LastModifiedBy
    @Column(insertable = false)
    private String updateUser;
}