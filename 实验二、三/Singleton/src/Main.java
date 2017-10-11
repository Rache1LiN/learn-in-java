
public class Main {
	public static void main(String [] args)
	{
		ChocolateBoiler cb=ChocolateBoiler.getSingelenton();
		cb.boil();
		cb.fill();
		cb.fill();
		cb.drain();
		cb.boil();
		cb.boil();
		cb.drain();
		
		cb.fill();
		cb.boil();
		cb.drain();
	}
}
