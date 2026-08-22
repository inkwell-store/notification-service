package com.wilson.inkwell.notification.mail;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

import org.springframework.stereotype.Component;

import com.wilson.inkwell.notification.entity.Email;
import com.wilson.inkwell.notification.enums.EmailStatus;
import com.wilson.inkwell.notification.repository.EmailRepository;

import lombok.RequiredArgsConstructor;

/**
 * Implementation of the {@link Sender} interface that saves the structure of an
 * email as file
 */
@Component
public class LocalOutputMailSender implements Sender {

    private final EmailRepository emailRepository;
    private final Path EMAIL_SINK_PATH = Path.of("/home/wilson/Desktop/projects/inkwell-store/emails");

    public LocalOutputMailSender(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;

        // create the folder dump if it doesn't exist yet
        try {
            Files.createDirectories(EMAIL_SINK_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendSingleNotification(SimpleMail simpleMail, Email emailEntity) {
        
        // Write the file. Filename could be `subject-type_id_timestamp.txt`
        String fileName = emailEntity.getSubjectType().toString() + 
                          "_" + 
                          emailEntity.getId() + 
                          "_" + 
                          emailEntity.getCreatedAt().toString() + 
                          ".txt"
        ;
       
        String content = "FROM: inkwell@gmail.com\n" +
                         "TO: " + simpleMail.recipient() + "\n" +
                         "SUBJECT: " + simpleMail.subject() + "\n\n" +
                         simpleMail.body()
        ;
        
        
        try {

            Files.writeString(EMAIL_SINK_PATH.resolve(fileName), content, StandardOpenOption.CREATE_NEW);
            // update the entity status
            emailEntity.setEmailStatus(EmailStatus.SENT);

        } catch (Exception e) {

            // TODO an ioexception here would suggest a programming error I think?
            // if so, how should I treat it?
            emailEntity.setEmailStatus(EmailStatus.NOT_SENT);

        } finally {
            emailRepository.save(emailEntity);
        }
        
    }

}
