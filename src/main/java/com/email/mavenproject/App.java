package com.email.mavenproject;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * Application to send e-mail
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
        System.out.println( "Send e-mail" );
        
        final String fromEmailID = "test.stub987@gmail.com";
        final String password = "********";
        final String toEmailID = "test.stub987@gmail.com";
        
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465"); //SMTP Port
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		
		
		Authenticator auth = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmailID, password);
			}
		};
			
        Session session = Session.getInstance(props, auth);
        
        SendEMail.sendEmail(session, toEmailID, "Subject", "Email Text");
     
		
    }
}
