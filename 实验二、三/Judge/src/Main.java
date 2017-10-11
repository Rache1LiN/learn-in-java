
public class Main {
	
	public static void main(String [] args)
	{
		Judge ju=new Judge();
		for(int i=1990;i<=2007;i++)
		{
			ju.setYear(i);
			ju.judge();
			if(Judge.count%2==0)
				System.out.println();
		}
	}
}
