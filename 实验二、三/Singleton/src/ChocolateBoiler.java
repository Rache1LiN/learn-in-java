
public class ChocolateBoiler {
	private boolean empty=true;
	private boolean boiled=false;
	private static ChocolateBoiler cb;
	private ChocolateBoiler(){
		
	}
	public static ChocolateBoiler getSingelenton(){
		if(cb==null){
			cb=new ChocolateBoiler();
		}
		return cb;
			
	}
	public void fill(){
		System.out.print("正在请求填充...  ");
		if(empty==false)
			System.out.println("锅炉已有正在填充的进程");
		else
		{
			System.out.println("填充过程进行成功");
			empty=false;
		}
			
	}
	public void boil(){
		System.out.print("正在请求煮沸...  ");
		if(isEmpty()==true)
		{
			System.out.println("请先填充锅炉");
		}
		else if(isBoiled()==true)
			System.out.println("已煮沸过不必再煮沸");
		else
		{
			System.out.println("煮沸进程成功完成");
			boiled=true;
		}
	}
	public void drain(){
		System.out.print("正在请求排出...  ");
		if(isEmpty()==true)
		{
			System.out.println("请先填充锅炉");
		}
		else if(isBoiled()==false)
			System.out.println("未煮沸请勿排出");
		else
		{
			System.out.println("排出进程成功完成");
			empty=true;
			boiled=false;
		}
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}

}
