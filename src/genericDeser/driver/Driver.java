package genericDeser.driver;

import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

public class Driver {

	public static String inputFile;
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=2)
		{
			System.out.println("Please enter valid number of arguments.");
		}
		 inputFile=args[0];
		int DEBUG_VALUE=Integer.parseInt(args[1]);
		Logger.setDebugValue(DEBUG_VALUE);
		int[] outArray=new int[4];
		 PopulateObjects populateObjects=new PopulateObjects();
		outArray=populateObjects.deserObjects(inputFile);
		String outputMessage="Number of Unique First Objects: "+outArray[0]+"\n"+"Number of Total First Objects: "+ outArray[1]+"\n"+"Number of Unique Second Objects: "+outArray[2]+"\n"+"Number of Total Second Objects: "+outArray[3];
		//System.out.println(outputMessage);
		//if(DEBUG_VALUE==0)
			Logger.writeMessage(outputMessage, Logger.DebugLevel.DISPLAY_OUTPUT);
		/*System.out.println("Number of Unique First Objects: "+outArray[0]);
		System.out.println("Number of Total First Objects: "+ outArray[1]);
		System.out.println("Number of Unique Second Objects: "+outArray[2]);
		System.out.println("Number of Total Second Objects: "+outArray[3]);*/
		
	}

}
