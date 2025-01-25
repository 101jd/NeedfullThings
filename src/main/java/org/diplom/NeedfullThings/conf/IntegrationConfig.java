package org.diplom.NeedfullThings.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.MailSendingMessageHandler;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class IntegrationConfig {

    @Bean
    public DirectChannel inputChannel(){
        return new DirectChannel();
    }

    @Bean DirectChannel outputChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public org.springframework.cglib.core.Transformer transformer(){
        return t -> t;
    }

    @Bean
    @ServiceActivator(inputChannel = "outputChannel")
    public MailSendingMessageHandler handler(JavaMailSender sender) {


        try{
            return new MailSendingMessageHandler(sender);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost");
        mailSender.setPort(2525);
        mailSender.setUsername("");
        mailSender.setPassword("");


        java.util.Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
