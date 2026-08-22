package com.wilson.inkwell.notification.mail;

/**
 * Utility class with static methods to generate SimpleEmail objects.
 */
public class MailGenerator {
    
    private MailGenerator() {

    }

    public static SimpleMail createAccountCreationMail(String recipientEmail) {
        return new SimpleMail(
            "Inkwell - Account creation", 
            recipientEmail,
            "Hello,\n\n"+ 
            "Welcome to the Inkwell Store webiste. " +
            "This is a confirmation email about you account creation and you don't need to respond.\n\n" +
            "<i>Inkwell team</i>"
        );
    }

}
