package com.wilson.inkwell.notification.entity;

import java.time.Instant;
import java.util.UUID;

import com.wilson.inkwell.notification.enums.EmailStatus;
import com.wilson.inkwell.notification.enums.EmailSubjectType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that represents an Email structure with suject, recipient, body etc...
 */
@Entity
@Table(name = "EMAIL_TBL")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    private EmailSubjectType subjectType;
    
    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;

    private String recipient;

    // private String body;

    private Instant createdAt;

}
