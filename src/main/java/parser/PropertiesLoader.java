package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	
	 public static void main(String[] args) {

			Properties prop = new Properties();
			InputStream input = null;

			try {

				input = new FileInputStream("C:\\Users\\user\\Desktop\\Java\\project\\mail.test\\lib\\date.txt");

				// load a properties file
				prop.load(input);

				// get the property value and print it out
				System.out.println(prop.getProperty("browser"));
				System.out.println(prop.getProperty("standurl"));
				System.out.println(prop.getProperty("userlogin"));
				System.out.println(prop.getProperty("userlogindomain"));

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

		  }

}
