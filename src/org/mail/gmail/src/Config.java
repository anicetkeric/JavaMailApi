package org.mail.gmail.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**##########################################################
 * @author ANICET ERIC KOUAME
 * @Date 10 févr. 2017 12:09:41
 * @Description:  load and reading config file
 * @Config
 *#################################################################*/
public class Config {

	public Config() throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(new File("config.conf")));
		
		Values.host = props.getProperty("GMAILHOST");
		Values.port = props.getProperty("PORT", "587");
		Values.user = props.getProperty("EMAIL");
		Values.pass = props.getProperty("PASSWORD");
		

	}
	
	


}
