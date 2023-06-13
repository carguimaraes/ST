package integracao;

import java.io.IOException;
import java.io.InputStream;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadJsonTest {

	public static void main(String[] args) {
		 System.out.println("*** INICIO ");
		 
		 System.out.println("*** FIM ");

	}
	
	private static void le() {
		
		ObjectMapper mapper = new ObjectMapper();
		
		MensagemDrive md= new MensagemDrive();
		
		md.setId(1967);
		md.setNome("CARLOS A L M GUIMARAES");
		
		ModelMapper xxx;
		
	}
	
	
	
	public static MenuLogin[] getMenu()  {
		ObjectMapper mapper = new ObjectMapper();
		 
		 MenuLogin[] menu=null;
		try {
			InputStream is= getFileFromResourceAsStream("jsonMock/db.menu.json");
			menu = mapper.readValue(is, MenuLogin[].class);
		 
			
		} catch (IOException e) {
			 return null;
		}
		
		return menu;
	}
	
	
	 private static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = null;// so para resolver o errogetClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
	

}
