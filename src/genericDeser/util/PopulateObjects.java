package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects {

	ArrayList<Object> first=new ArrayList<Object>();
	ArrayList<Object> second=new ArrayList<Object>();
	HashSet<Object> hs = new HashSet<Object>();
	HashSet<Object> hs1 = new HashSet<Object>();
	HashMap<String, Class> dataTypeMap = new HashMap<String, Class>();
	Object object = null;
	Class cls = null;
	int[] outArray=new int[4];
	String str;
	private int firstTotalCount=0;
	private int firstDistinctCount=0;
	private int secondTotalCount=0;
	private int secondDistinctCount=0;
	
	public PopulateObjects(){
		dataTypeMap.put("int", Integer.TYPE);
		dataTypeMap.put("float", Float.TYPE);
		dataTypeMap.put("short", Short.TYPE);
		dataTypeMap.put("String", String.class);
		dataTypeMap.put("boolean", Boolean.TYPE);
		dataTypeMap.put("double", Double.TYPE);
	}
	public int[] deserObjects(String inFile)
	{
		
		FileProcessor fileProcessor=new FileProcessor();
		fileProcessor.initiateFileProcessing(inFile);
		str=fileProcessor.readOneLine();
		try{
		while(str!=null)
		{
			//System.out.println(str);
			//fileProcessor.writeIntoFile(str);
			if(str.contains("fqn:"))
			{
				String clsName[]=str.split(":");
			    cls=Class.forName(clsName[1]);
				object = cls.newInstance();
				}
			else
			{
							String sign[]=str.split(",");
							String values0[]=sign[0].split("=");
							String values1[]=sign[1].split("=");
							String values2[]=sign[2].split("=");
							Class[] signature =new Class[1];
							signature[0]=dataTypeMap.get(values0[1]);
							String methdName="set"+ values1[1];
							
								Method meth=cls.getMethod(methdName,signature);
							
							Object[] params=new Object[1];
							switch(values0[1])
							{
							case "int":params[0]=new Integer(Integer.parseInt(values2[1]));
										break;
							case "short":params[0]=new Short(Short.parseShort(values2[1]));
										break;
							case "double":params[0]=new Double(Double.parseDouble(values2[1]));
										break;
							case "String":params[0]=new String(values2[1]);
										break;
							case "boolean":params[0]=new Boolean(Boolean.parseBoolean(values2[1]));
										break;
							case "float":params[0]=new Float(Float.parseFloat(values2[1]));
										break;
							}
							
								Object result=meth.invoke(object,params);
								
								
							
							
						}
					 str = fileProcessor.readOneLine();
					 if(str==null){
						 calculateCount();
					 }
					 else if(str.contains("fqn:")){
						 
							 calculateCount();
						 }
					 
				}
			/*for(Object o: first){
				for(Object b:first){
					if(o.equals(b)){
						break;
					}
				}
			}*/
		
		
		}
		
		catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileProcessor.endFileProcessing();
		/*System.out.println("Number of Total First Objects: "+ firstTotalCount);
		System.out.println("Number of Distcinct First Objects: "+firstDistinctCount);
		System.out.println("Number of Total Second Objects: "+secondTotalCount);
		System.out.println("Number of Distinct Second Objects: "+secondDistinctCount);*/
		outArray[0]=firstDistinctCount;
		outArray[1]=firstTotalCount;
		outArray[2]=secondDistinctCount;
		outArray[3]=secondTotalCount;
		
		return outArray;
		}
	
	private void calculateCount(){
		if(object.getClass().getSimpleName().equals("First")){
			if(hs.isEmpty()){
				hs.add(object);
				firstDistinctCount++;
				firstTotalCount++;
			}
			else{
					if(hs.contains(object)){
						firstTotalCount++;
					}
					else{
						hs.add(object);
						firstDistinctCount++;
						firstTotalCount++;
					}
				
			}
			
		}
		else {
			if(hs1.isEmpty()){
				hs1.add(object);
				secondDistinctCount++;
				secondTotalCount++;
			}
			else{
					if(hs1.contains(object)){
						secondTotalCount++;
					}
					else{
						hs1.add(object);
						secondDistinctCount++;
						secondTotalCount++;
					}
				
			}
			
		}
	}
}

