import java.util.Random;

public class ChocolateBoiler implements Runnable{
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
	public synchronized void fill(){
		System.out.print("�����������...  ");
		if(empty==false)
			System.out.println("��¯�����������Ľ���");
		else
		{
			System.out.println("�����̽��гɹ�");
			empty=false;
		}
			
	}
	public synchronized void boil(){
		System.out.print("�����������...  ");
		if(isEmpty()==true)
		{
			System.out.println("��������¯");
		}
		else if(isBoiled()==true)
			System.out.println("����й����������");
		else
		{
			System.out.println("��н��̳ɹ����");
			boiled=true;
		}
	}
	public synchronized void drain(){
		System.out.print("���������ų�...  ");
		if(isEmpty()==true)
		{
			System.out.println("��������¯");
		}
		else if(isBoiled()==false)
			System.out.println("δ��������ų�");
		else
		{
			System.out.println("�ų����̳ɹ����");
			empty=true;
			boiled=false;
		}
	}
	public synchronized boolean isEmpty(){
		return empty;
	}
	public synchronized boolean isBoiled(){
		return boiled;
	}
	public void run() {
		// TODO Auto-generated method stub
		Random rand=new Random();
		while(true)
		{
			
			try{
				
				switch(rand.nextInt(3)%3){
					case 1:Thread.sleep(500);boil();System.out.println(Thread.currentThread().getName());Thread.sleep(1000);break;
					case 2:Thread.sleep(500);drain();System.out.println(Thread.currentThread().getName());Thread.sleep(1000);break;
					case 0:Thread.sleep(500);fill();System.out.println(Thread.currentThread().getName());Thread.sleep(1000);break;
					default:System.out.println("error");break;
				}
			
				
				
				
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
	
}
