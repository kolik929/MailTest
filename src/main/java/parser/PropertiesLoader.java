package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesLoader {
//	   public static void main(String[] args){
//		  System.out.println(getProperti("mainUrl")); 
//		   
//	   }
//	
	
	 public   String getProperty(String value) {

			Properties prop = new Properties();
			InputStream input = null;
			String out = "";
			try {

				input = new FileInputStream("C:\\Users\\user\\Desktop\\Java\\project\\mail.test\\lib\\date.txt");

				// load a properties file
				prop.load(input);

				// get the property value and print it out
//				System.out.println(prop.getProperty("mainUrl"));
//				System.out.println(prop.getProperty("login"));
//				System.out.println(prop.getProperty("password"));
//				System.out.println(prop.getProperty("domain"));
				out = new String((prop.getProperty(value)).getBytes("ISO-8859-1"), "UTF-8");
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		}
			return out;
	  }

}
