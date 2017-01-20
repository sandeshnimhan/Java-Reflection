package genericDeser.fileOperations;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import genericDeser.driver.Driver;
import genericDeser.util.Logger;

public class FileProcessor {
	private FileReader fr;
	private BufferedReader br;
	/*private FileWriter fw;
	private BufferedWriter bw;*/
	
	public FileProcessor(){
		Logger.writeMessage("FileProcessor Constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	static String line=null;
	public void initiateFileProcessing(String inFile) {
		Logger.writeMessage("File Processing Initiated", Logger.DebugLevel.FILE_PROCESSING);
		// TODO Auto-generated method stub
		try{
			fr=new FileReader(Driver.inputFile);
			br=new BufferedReader(fr);
			/*fw=new FileWriter("output.txt");
			bw=new BufferedWriter(fw);*/
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public String readOneLine() {
		// TODO Auto-generated method stub
		try{
			
			line=br.readLine();
			return line;
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return line;
	}
	
	/*public void writeIntoFile(String str)
	{
		try {
			bw.write(str);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public void endFileProcessing() {
		// TODO Auto-generated method stub
		try {
			br.close();
			//bw.close();
			//fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
