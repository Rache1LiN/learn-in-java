import java.io.*;
import java.util.Scanner;

public class baseIO {
 
	public static void main(String[] args) {  
	    String b; 
	    
	    Scanner scan = new Scanner(System.in);
	    File out=new File("src.txt");
	    File outFile = new File("dest.txt");
	    try {  
	    	
	        PrintWriter fout=new PrintWriter(out);
	        System.out.println("please Input:");  
	        do{  
	        	b = scan.nextLine();
	        	
	            fout.write(b+"\r\n");
	        }while (!b.equals(" "));
	        
	        fout.close();
	        scan.close();
	  
	        Reader finS = new FileReader(out);  
	        PrintWriter foutS=new PrintWriter(outFile);
	        BufferedReader br=new BufferedReader(finS);  
	        
	        while ((b= br.readLine())!=null){  
	        	
	            foutS.write(b+"\r\n");  
	        }
	        
	        finS.close();
	        foutS.close();
	    } catch (IOException e) {  
	        System.out.println(e.toString());  
	    }  
	}  
	

}
