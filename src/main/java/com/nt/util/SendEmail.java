package com.nt.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nt.util.GenerateTemplate;

@Service
public class SendEmail {
	@Autowired
	private Environment env;

	//@Value("${From}")
	//private static String from;
	//@Value("${To}")
	//private static String to;
	//@Value("${Subject}")
	//private static String subject;
	@Autowired
	private  JavaMailSender javaMailSender;

	public void sendEmail() {
		System.out.println("Sending Email...");
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("niharikabarik53@gmail.com");
		msg.setTo("niharikabarik2@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		//javaMailSender.send(msg);
		System.out.println("Done");
	}

	
	public void emailSend() throws MessagingException, IOException{
		
		final String username = env.getProperty("spring.mail.username");//change accordingly
        final String password =env.getProperty("spring.mail.password");//change accordingly
        // Assuming you are sending email through relay.jangosmtp.net
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
		
		// Create a default MimeMessage object.
        Message message =  new MimeMessage(session);
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(env.getProperty("from")));
        // Set To: header field of the header.
        message.setRecipient(Message.RecipientType.TO,
        		new InternetAddress(env.getProperty("to")));
        // Set Subject: header field
        message.setSubject(env.getProperty("subject"));
        // Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();
        // Now set the actual message
        messageBodyPart.setText("Please find the attachment below");
        // Create a multipar message
        Multipart multipart = new MimeMultipart();
        // Set text message part
        multipart.addBodyPart(messageBodyPart);
        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "D:/spring_prgms_workspace/FirstPdf.pdf";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(source.getName());
        multipart.addBodyPart(messageBodyPart);
        // Send the complete message parts
        message.setContent(multipart);
        // Send message
        Transport.send(message);
        System.out.println("Email Sent Successfully !!");
	}
}
