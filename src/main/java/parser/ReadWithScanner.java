package parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadWithScanner {
	

	
	  private final Path fFilePath;
	  private final static Charset ENCODING = StandardCharsets.UTF_8;  
	  
	  private static void log(Object aObject){
	    System.out.println(String.valueOf(aObject));
	  }
	  
	  private String quote(String aText){
	    String QUOTE = "'";
	    return QUOTE + aText + QUOTE;
	  }
	  
	  public static void main(String... aArgs) throws IOException {
			ReadWithScanner parser = new ReadWithScanner("C:\\Users\\user\\Desktop\\Java\\project\\mail.test\\lib\\date.txt");
		    parser.processLineByLine();
		    log("Done.");
		  }
	  
	  
	
	  /**
	   Constructor.
	   @param aFileName full name of an existing, readable file.
	  */
	  public ReadWithScanner(String aFileName){
	    fFilePath = Paths.get(aFileName);
	  }

	  
	  public final void processLineByLine() throws IOException {
		    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
		      while (scanner.hasNextLine()){
		        processLine(scanner.nextLine());
		      }      
		    }
		  }
		  

	  

	  protected void processLine(String aLine){
	    //use a second Scanner to parse the content of each line 
	    Scanner scanner = new Scanner(aLine);
	    scanner.useDelimiter(":");
	    if (scanner.hasNext()){
	      //assumes the line has a certain structure
	      String name = scanner.next();
	      String value = scanner.next();
	 
	      String[] param = {"browser","standurl","userlogin","userlogindomain","userpassword","mailtext","maildate"};
	      for (int i = 0;i< param.length;i++){
	    	  if(name.contains(param[i])){
	    		 		  
	    		  String a = param[i]+"="+value;
	    		  System.out.println(a);
	    	  }
	      }
	      
//	      String[] param = {"browser","standurl","userlogin","userlogindomain","userpassword","mailtext","maildate"};
//	      	for(name in param[]){
//	      		
//	      	}
	      
//	      log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
	    }
	    else {
	      log("Empty or invalid line. Unable to process.");
	    }
	  }
	  
	  
	

	  
}
