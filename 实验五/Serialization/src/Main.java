import java.util.SortedSet;
import java.util.TreeSet;
public class Main {
	public static void main(String [] args)throws Exception
	{
		SortedSet<Student> ts=new TreeSet<>();
		SerializationObject so=new SerializationObject();
		so.readFile(ts);
		so.ObjectIO(ts);
	}
}
