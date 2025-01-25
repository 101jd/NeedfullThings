package org.diplom.NeedfullThings.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mail.MailHeaders;
import org.springframework.integration.mail.MailSendingMessageHandler;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface MailGateway {

    MailSendingMessageHandler sendEmail(@Header(MailHeaders.FROM) String from, @Header(MailHeaders.TO) String to,
                                        @Header(MailHeaders.SUBJECT) String subject, String payload);
}
