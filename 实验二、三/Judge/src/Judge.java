
public class Judge {
	private int year;
	static int count=0;
	public void judge(){
		if((year%4==0 && year %100!=0)||year%400==0)
			{
				System.out.print(year+" ");
				count++;
			}
			
	}
	public void setYear(int year)
	{
		this.year=year;
	}
}
