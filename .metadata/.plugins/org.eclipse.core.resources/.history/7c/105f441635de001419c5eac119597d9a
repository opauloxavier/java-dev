package indexer;

public class RestoreByte extends ByteMaker {

	public char restoreChar(String a){ 
		
		char properChar = (char) Integer.parseInt(a,2);
		
		return properChar;
	}
	
	public String restoreString(String a){
		
		String properString=new String();
		
		for(int i=0,j=0;i<a.length();i++)
		{
			if(i==7){
				String temp = a.substring(0, i+1);
				properString+=restoreChar(temp);
				j+=2;
			}
			
			else if(i==j*8-1)
			{
				String temp = a.substring((j-1)*8, i+1);
				properString+=restoreChar(temp);
				j++;
			}	
			
		}
		
		return properString;
	}
	
	
}
