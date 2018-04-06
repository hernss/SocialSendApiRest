package com.socialsend.sendapi.email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendMail {

	// Singleton Variables and Procedures
	private static SendMail instance = null;
	
	public static SendMail getInstance() {
      if(instance == null) {
         instance = new SendMail();
      }
      return instance;
	}
	//End Singleton
		
    private String host, port, emailid, username, password;
    Properties props = System.getProperties();
    Session l_session = null;

   
    public SendMail() {
    	host = "smtp.mail.yahoo.com";
        port = "587";
        emailid = "socialsend@yahoo.com";
        username = "socialsend";
        password = "######"; //Ya cambie el password expuesto
               
        emailSettings();
        createSession();
    }

    private void emailSettings() {
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", username);
    }

    private void createSession() {

        l_session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        //l_session.setDebug(true); 
    }

    public boolean sendMessage( String toEmail, String subject, String msg) {
        
        try {
           
            MimeMessage message = new MimeMessage(l_session);
            
            message.setFrom(new InternetAddress(this.emailid));
           
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
          
            message.setSubject(subject);
         
            message.setContent(msg, "text/html");

            Transport.send(message);
            System.out.println("Email Sent");
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {
    	Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher matcher = pattern.matcher(email);
 
        return matcher.find();
    }
}