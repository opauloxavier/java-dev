package fileManager;
import java.io.*;

public class Writer {
	
	public String defaultPath(){
		String path = new String();
		
    	if(System.getProperty("os.name").startsWith("Windows"))
    		path="D:/GitHub/java-dev/indexer";
    	else
    		path="";
    	
    	return path;
	}
	
	public void makeFile(String a,String fileName){
		
		 BufferedWriter writer = null;
		
    	try{    	
	    	writer = new BufferedWriter(new FileWriter(fileName));
	        writer.write(a);
    	}
    	catch(IOException e)
    	{
    		
    	}
    	finally{
    		try{
    			if (writer!=null)
    				writer.close();
    		}
    		catch(IOException e)
    		{
    			
    		}
    	}
	}
	
	public String readFile(String path){
		
		BufferedReader br = null;
		String finalString=new String();
		
		try {
 
			String sCurrentLine;
	
 
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
				finalString+=sCurrentLine;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return finalString;
	}
	
	
	
    public static void main(String[] args) throws IOException {

    
    }
}