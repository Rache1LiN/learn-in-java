
import java.util.TreeSet;
import java.util.SortedSet;
public class Main {
	public static void main(String args[])throws Exception{
		wrFile wr=new wrFile();
		//wr.createFile();
		SortedSet<Task> ts=new TreeSet<>();
		
		wr.readFile(ts);
		FSCS fs=new FSCS();
		fs.fscsSingle(ts);
		
		System.out.println("�ȵ��ȷ���\n������");
		System.out.println(ts);

		System.out.println();
		
		wrFile wr1=new wrFile();
		SortedSet<Task> ts1=new TreeSet<>();
		
		wr1.readFile(ts1);
		fs.fscsDouble(ts1);
		System.out.println("˫����");
		fs.printDouble(ts1);
		
		System.out.println();
		wrFile wr2=new wrFile();
		SortedSet<Task> ts2=new TreeSet<>();
		SJF sjf=new SJF();
		wr2.readFile(ts2);
		sjf.sjfSingle(ts2);
		System.out.println("����ҵ���ȣ�\n������");
		System.out.println(ts2);
		
		System.out.println();
		wrFile wr3=new wrFile();
		SortedSet<Task> ts3=new TreeSet<>();
		
		wr3.readFile(ts3);
		sjf.sjfDouble(ts3);
		System.out.println("˫����");
		sjf.printDouble(ts3);
		
	}
}
