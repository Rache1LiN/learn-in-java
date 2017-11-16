import java.io.*;
import java.util.*;
import java.text.*;
public class filenameIO {
	public void test() {
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter filepath");
		String str=scan.nextLine();
		
        String fileName=str;
        
        File file = new File(fileName);
        print(file);
        scan.close();
	}

	public void print(File f) {
        if (f != null) 
        {

            	TreeSet ts=new TreeSet(new MyComparator());
            	File t;
                File [] arr = f.listFiles();
                File out=new File("filename.txt");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                
                if (arr != null)
                {
                	for(int i=0;i<arr.length;i++)
                	{

                			ts.add(arr[i]);
                	}
                	
                	try{
                		PrintWriter fout=new PrintWriter(out);
                		Iterator it1=ts.iterator();
                    	Iterator it2=ts.iterator();
	                	String b;
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it1.next();
	                    	if (t.isDirectory()) 
	                        {
		                    	System.out.println(b=(t.getName()+"\t修改时间："+df.format( new Date(t.lastModified()))));
		                    	fout.write(b+"\r\n");
	                    		
	                        }
	                    }
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it2.next();
	                    	if (!t.isDirectory()) 
	                        {
	                    		
	                    		
	                            System.out.println(b=(t.getName()+"\t大小:"+t.length()+"字节"+"\t修改时间："+df.format( new Date(t.lastModified()))));
	                            fout.write(b+"\r\n");
	                        }
	                    }
	                	fout.close();
                	}catch (IOException e){
                		System.out.println(e.toString());
                	}
                }
             
                
        }
	}
	public static void main(String [] args){
		filenameIO f=new filenameIO();
		f.test();
		
	}
}
