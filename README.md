# JavaMailApi
Send an Email via GMail SMTP

# Overview

The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications. The JavaMail API is available as an optional package for use with the Java SE platform and is also included in the Java EE platform.
http://www.oracle.com/technetwork/java/javamail/index.html

## Apache POI Maven Dependencies
```xml
<dependency>
	<groupid>javax.mail</groupid>
	<artifactid>mail</artifactid>
	<version>1.4.7</version>
</dependency>
 
<dependency>
	<groupid>javax.mail</groupid>
	<artifactid>javax.mail-api</artifactid>
	<version>1.5.5</version>
</dependency>

```

/*SMTP settings*/ 
get settings smtp in config.conf file


## Java example - Send e-mail with attachment

```java
 public static void sendEmail(String host, String port,
	            final String userName, final String password, String toAddress,
	            String subject, String message, String[] attachFiles) throws AddressException,
	            MessagingException {
	 
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.ssl.trust", host);


	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	       // msg.setText(message);
	        
	        // Send the actual HTML message, as big as you like
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html");
	        
	 
	     // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	 
	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	 
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
	        
	        
	        // send the e-mail
	        Transport.send(msg);
	        System.out.println("Mail Session has been created successfully....");
	    }

```
