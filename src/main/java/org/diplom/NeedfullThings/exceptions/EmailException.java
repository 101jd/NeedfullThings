package org.diplom.NeedfullThings.exceptions;

import org.springframework.mail.MailException;

public class EmailException extends MailException {
    public EmailException() {
        super("Mailing failed");
    }
}
