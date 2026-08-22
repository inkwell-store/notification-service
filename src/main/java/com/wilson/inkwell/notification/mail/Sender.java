package com.wilson.inkwell.notification.mail;

import com.wilson.inkwell.notification.entity.Email;

/**
 * Interface to model any class that might send notifications via email.
 */
public interface Sender {

    /**
     * Sends a single {@link SimpleMail}
     * 
     * @param simpleMail  the body of the
     * @param emailEntity the email that persisted before being sent
     */
    void sendSingleNotification(SimpleMail simpleMail, Email emailEntity);

}
