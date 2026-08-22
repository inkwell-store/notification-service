package com.wilson.inkwell.notification.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.wilson.inkwell.notification.dto.CredentialCreationEvent;
import com.wilson.inkwell.notification.entity.Email;
import com.wilson.inkwell.notification.enums.EmailStatus;
import com.wilson.inkwell.notification.enums.EmailSubjectType;
import com.wilson.inkwell.notification.mail.MailGenerator;
import com.wilson.inkwell.notification.mail.Sender;
import com.wilson.inkwell.notification.mail.SimpleMail;
import com.wilson.inkwell.notification.repository.EmailRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service responsible for sending notifications
 */
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EmailRepository emailRepository;
    private final Sender sender;

    public void processCredentialCreation(CredentialCreationEvent event) {

        // persist the email data
        Email newEntity = new Email();
        newEntity.setCreatedAt(Instant.now());
        newEntity.setSubjectType(EmailSubjectType.ACCOUNT_CREATED_CONFIRMATION);
        newEntity.setRecipient(event.email());
        newEntity.setEmailStatus(EmailStatus.NOT_SENT);

        Email savedEntity = emailRepository.save(newEntity);

        // then send the notification to the file system
        SimpleMail mail = MailGenerator.createAccountCreationMail(event.email());
        sender.sendSingleNotification(mail, savedEntity);

    }

}
