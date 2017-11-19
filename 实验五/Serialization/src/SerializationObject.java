import java.util.SortedSet;
import java.io.*;
import java.util.Iterator;
public class SerializationObject {
	public void readFile(SortedSet<Student> ts)throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("list.txt"),"UTF-8"));
		String s;
		while((s=br.readLine())!=null){
			
			String [] str=s.split(" ");
			
			Student t=new Student(Long.parseLong(str[0]),str[1],str[2]);
			
			ts.add(t);
		}

		br.close();
	}
	public void ObjectIO(SortedSet<Student> ts)throws Exception
	{
		Student s=new Student();
		Student t=null;
		String filename = "student.bin";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			Iterator it=ts.iterator();
			while(it.hasNext())
			{
				out.writeObject((Student)it.next());
			}
			out.writeObject(t);
			out.close();
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			while((s=(Student)in.readObject())!=null){
				System.out.println(s.getNumber() + " " + s.getName()+" "+s.getSex());
			}
			in.close();
			} catch (IOException ex) {
			   ex.printStackTrace();
			}

	}
}
