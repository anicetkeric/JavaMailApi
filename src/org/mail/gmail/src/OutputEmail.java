/**#################################################################
 * 
 **#################################################################*/
package org.mail.gmail.src;


/**#################################################################
 * @author ANICET ERIC KOUAME
 * @Date: 27 févr. 2017
 * @Description:
 *OutputEmail
 *#################################################################*/

public class OutputEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  String subject = "Send an Email via GMail SMTP";						  
		  		  
		  String content = "<i>Hello,</i><br>";
		  content += "<p>Test email by JavaMail API example.</p>";	        		 
		  content += "<font color=#0f037d>Best regard.</font>";
		  
		  String toEmail="anicetkeric@gmail.com";
		
		  // attachments
	        String[] attachmentFiles = new String[2];
	        attachmentFiles[0] = "config.conf";
	        attachmentFiles[1] = "config.conf";
		  
       try {
    	    new Config();
          EmailUtility.sendEmail(Values.host , Values.port, Values.user, Values.pass, toEmail, subject,content,attachmentFiles);
     
       } catch (Exception ex) {
           ex.printStackTrace();
           
       } 		
		
		
		
		
	}

}
