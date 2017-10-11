
public class Print {
	private char a;
	private char b;
	Print(){
		a='*';
		b=' ';
	}
	public void prin(){
		for(int i=0;i<7;i++)
		{
			if(i<4)
			{
				for(int j=0;j<5-i;j++)
				{
					System.out.print(b);
				}
				for(int k=0;k<(i+1)*2-1;k++)
				{
					System.out.print(a);
				}
			}
			else
			{
				for(int j=0;j<i-1;j++)
				{
					System.out.print(b);
				}
				for(int k=0;k<(7-i)*2-1;k++)
				{
					System.out.print(a);
				}
			}
			System.out.println();
		}
		
	}
	
}

