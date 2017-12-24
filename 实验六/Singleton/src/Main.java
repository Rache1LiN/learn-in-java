
public class Main {
	public static void main(String [] args) throws InterruptedException
	{
		ChocolateBoiler cb=ChocolateBoiler.getSingelenton();
//		cb.boil();
//		cb.fill();
//		cb.fill();
//		cb.drain();
//		cb.boil();
//		cb.boil();
//		cb.drain();
//		
//		cb.fill();
//		cb.boil();
//		cb.drain();
		Thread tA=new Thread(cb);
		Thread tB=new Thread(cb);
		Thread tC=new Thread(cb);
		Thread tD=new Thread(cb);
		tA.start();
		tB.start();
		tC.start();
		tD.start();
	}
}
