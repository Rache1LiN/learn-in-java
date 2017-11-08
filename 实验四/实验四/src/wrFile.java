import java.io.*;
import java.util.SortedSet;
import java.util.Random;
public class wrFile {
	public void createFile()
	{

		int [] arr={6,2,1,3,9};
		File datafile=new File("../dataFile.txt");
		if(!datafile.exists())
		{
			try{
				datafile.createNewFile();
			}
			catch(IOException e){
				System.out.println("创建文件失败！");
			}
		}
		try{
			PrintWriter pw=new PrintWriter(datafile);
		
			for(int i=1;i<=100;i++)
			{
				Random r=new Random();
				pw.write(i+" "+(i-1)+" "+arr[r.nextInt(5)]);
				pw.write("\r\n");
			}
			pw.close();
		}
		catch(FileNotFoundException e){
			System.out.println("找不到文件！");
		}
	}
	public void readFile(SortedSet<Task> ts)throws Exception
	{
		BufferedReader br=new BufferedReader(new FileReader("../dataFile.txt"));
		for(int i=1;i<=100;i++){
			String s=br.readLine();
			String [] str=s.split(" ");
			Task t=new Task(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			ts.add(t);
		}
		
			
		
		br.close();
	}

	
}
