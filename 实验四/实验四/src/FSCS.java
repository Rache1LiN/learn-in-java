import java.util.Iterator;
import java.util.SortedSet;

public class FSCS {
	public void fscsSingle(SortedSet<Task> ts){
		int lastFinTime=0;
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		for(int i=1;i<=100;i++)
		{
			t=iterator.next();
			if(t.getArrTime()>=lastFinTime)
				t.setStart(t.getArrTime());
			else
				t.setStart(lastFinTime);
			t.setFinish(t.getStartTime()+t.getSerTime());
			t.setTurnAround(t.getFinTime()-t.getArrTime());
			t.setWeight((double)t.getTurnAround()/t.getSerTime());
			lastFinTime=t.getFinTime();
		}
	}
	public void fscsDouble(SortedSet<Task> ts){
		int lastTime1=0;
		int lastTime2=0;
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		for(int i=1;i<=100;i++){
			t=iterator.next();
			if(t.getArrTime()>=lastTime1 && t.getArrTime()>=lastTime2)
			{

				t.setStart(t.getArrTime());
				t.setFinish(t.getStartTime()+t.getSerTime());
				t.setTurnAround(t.getFinTime()-t.getArrTime());
				t.setWeight((double)t.getTurnAround()/t.getSerTime());
				if((t.getArrTime()-lastTime1)>=(t.getArrTime()-lastTime2))
				{
					
					t.setTag(1);
					
					lastTime1=t.getFinTime();
				}
				else 
				{
					t.setTag(2);
					lastTime2=t.getFinTime();
					
				}
				
			}
			else if(t.getArrTime()>=lastTime1 || t.getArrTime()>=lastTime2)
			{
				if(t.getArrTime()>=lastTime1)
				{
					t.setStart(t.getArrTime());
					t.setTag(1);
					t.setFinish(t.getStartTime()+t.getSerTime());
					t.setTurnAround(t.getFinTime()-t.getArrTime());
					t.setWeight((double)t.getTurnAround()/t.getSerTime());
					lastTime1=t.getFinTime();
				}
				else
				{
					
					t.setStart(t.getArrTime());
					t.setTag(2);
					t.setFinish(t.getStartTime()+t.getSerTime());
					t.setTurnAround(t.getFinTime()-t.getArrTime());
					t.setWeight((double)t.getTurnAround()/t.getSerTime());
					lastTime2=t.getFinTime();
				}
			}
			else if(t.getArrTime()<lastTime1 && t.getArrTime()<lastTime2)
			{
				if((lastTime1-t.getArrTime())<=(lastTime2-t.getArrTime()))
				{
					t.setStart(lastTime1);
					t.setTag(1);
					t.setFinish(t.getStartTime()+t.getSerTime());
					t.setTurnAround(t.getFinTime()-t.getArrTime());
					t.setWeight((double)t.getTurnAround()/t.getSerTime());
					lastTime1=t.getFinTime();
				}
				else
				{
					t.setStart(lastTime2);
					t.setTag(2);
					t.setFinish(t.getStartTime()+t.getSerTime());
					t.setTurnAround(t.getFinTime()-t.getArrTime());
					t.setWeight((double)t.getTurnAround()/t.getSerTime());
					lastTime2=t.getFinTime();
				}
			}
			
		}
	}
	public void printDouble(SortedSet<Task> ts){
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		/*Iterator<Task> iterator1=ts.iterator();
		System.out.println("队列1");
		for(int i=0;i<100;i++)
		{
			t=iterator.next();
			if(t.getTag()==1)
				System.out.println(t.getID()+" "+t.getArrTime()+" "+t.getSerTime()+" "+t.getStartTime()+" "+t.getFinTime()+" "+t.getTurnAround()+" "+t.getWeight());
		}
		
		System.out.println("\n\n队列2");
		for(int i=0;i<100;i++)
		{
			t=iterator1.next();
			if(t.getTag()==2)
				System.out.println(t.getID()+" "+t.getArrTime()+" "+t.getSerTime()+" "+t.getStartTime()+" "+t.getFinTime()+" "+t.getTurnAround()+" "+t.getWeight());
		}*/
		for(int i=0;i<100;i++)
		{
			t=iterator.next();
			System.out.println(t.getID()+" "+t.getArrTime()+" "+t.getSerTime()+" "+t.getStartTime()+" "+t.getFinTime()+" "+t.getTurnAround()+" "+t.getWeight());

		}
		
	}
}
