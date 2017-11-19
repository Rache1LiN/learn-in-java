import java.io.*;
public class IOcompare {
	public void withoutBuffer(){
		try{
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withoutBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			while((c=finS.read())!=-1)
			{
				foutS.write(c);
			}
			foutS.close();
			finS.close();
		}catch(IOException e){
			System.err.println("FileStreamTest:"+e);
		}
	}
	public void withBuffer(){
		try{
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			BufferedReader bfinS=new BufferedReader(finS);
			BufferedWriter bfoutS=new BufferedWriter(foutS);
			while((c=bfinS.read())!=-1)
			{
				bfoutS.write(c);
			}
			bfoutS.close();
			bfinS.close();
		}catch(IOException e){
			System.err.println("FileStreamTest:"+e);
		}
	}
	public static void main(String [] args)
	{
		IOcompare io=new IOcompare();
		long startTime = System.currentTimeMillis();
		io.withoutBuffer();
		long endTime = System.currentTimeMillis();
		System.out.println("copy file without Buffer:"+(endTime-startTime)+"ms");
		long startTime1 = System.currentTimeMillis();
		io.withBuffer();
		long endTime1 = System.currentTimeMillis();
		System.out.println("copy file with Buffer:"+(endTime1-startTime1)+"ms");
	}
}
