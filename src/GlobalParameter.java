import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalParameter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/**
 * TO SET GLOBAL PARAMETER IN JAVA
 * FIRST- Create a .properties file and store the variables there e.g the data.properties
 * file created for this
 * create a Properties object
 * use FileInputStream to read the file from the .properties file path created
 * then use the Properties object to load the file
 * then use .getProperty to get the file
 * .setProperty can also be used to set new property in the .properties file in real time
 * FileOutputStream can then be used to updated property set to the .properties file
 * this will modify whatever is in the .properties file
 * Properties().store can now be used to write it to the .properties file

 */
		
		Properties prop = new Properties();
		FileInputStream fileinput = new FileInputStream("C:\\Users\\odunlamib\\eclipse-workspace\\Learning\\src\\data.properties");
		prop.load(fileinput);
		System.out.println(prop.getProperty("browser"));
		prop.setProperty("browser","firefox");
		System.out.println(prop.getProperty("browser"));
		FileOutputStream fileoutput = new FileOutputStream("C:\\Users\\odunlamib\\eclipse-workspace\\Learning\\src\\data.properties");
		prop.store(fileoutput, null);
	}

}
