
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
		System.out.print("�����������...  ");
		if(empty==false)
			System.out.println("��¯�����������Ľ���");
		else
		{
			System.out.println("�����̽��гɹ�");
			empty=false;
		}
			
	}
	public void boil(){
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
	public void drain(){
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
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}

}
