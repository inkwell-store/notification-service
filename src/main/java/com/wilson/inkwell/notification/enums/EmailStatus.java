package com.wilson.inkwell.notification.enums;

import com.wilson.inkwell.notification.entity.Email;

/**
 * Enum that represents the status of any given email.
 * By default, when an {@link Email} Entity is saved for the first time the
 * <code>NOT_SENT</code> status is set.
 */
public enum EmailStatus {

    /**
     * The email was sent without any exceptions being throw. For SMTP
     * providers this <b>DOES NOT</b> mean the recipient received it.
     */
    SENT,

    /** The email was not sent by this server yet, normally indicating the  */
    NOT_SENT,

    /** The email was not sent due to an error. */
    ERROR_WHILE_SENDING
}
