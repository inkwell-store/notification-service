package com.wilson.inkwell.notification.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.wilson.inkwell.notification.dto.CredentialCreationEvent;

@Service
public class RabbitMqListenerService {

    private final NotificationService notificationService;

    public RabbitMqListenerService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "notification.credential-queue")
    public void listenToCredentialCreationEvent(@Payload CredentialCreationEvent event) {
        notificationService.processCredentialCreation(event);
    }

}
