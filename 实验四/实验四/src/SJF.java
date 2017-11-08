import java.util.Iterator;
import java.util.SortedSet;
public class SJF {
	public int updateSingle(SortedSet<Task> ts,int ID,int lastTime)
	{
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		for(int i=0;i<100;i++)
		{
			t=iterator.next();
			if(t.getID()==ID)
			{
				break;
			}
		}
		if(t.getArrTime()>=lastTime)
			t.setStart(t.getArrTime());
		else
			t.setStart(lastTime);
		t.setFinish(t.getStartTime()+t.getSerTime());
		t.setTurnAround(t.getFinTime()-t.getArrTime());
		t.setWeight((double)t.getTurnAround()/t.getSerTime());
		t.setTag(1);
		lastTime=t.getFinTime();
		return lastTime;
		
	}
	
	public int[] updateDouble(SortedSet<Task> ts,int ID,int [] lastTime)
	{
		int lastTime1=lastTime[0];
		int lastTime2=lastTime[1];
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		for(int i=0;i<100;i++)
		{
			t=iterator.next();
			if(t.getID()==ID)
			{
				break;
			}
		}
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
		lastTime[0]=lastTime1;
		lastTime[1]=lastTime2;
		return lastTime;
		
	}
	public int findMin(SortedSet<Task> ts,int lastTime)
	{
		Task k=new Task();
		int Min=10;
		int ID=0;
		Iterator<Task> iterator=ts.iterator();
		for(int j=0;j<100;j++)
		{
			k=iterator.next();
			if(k.getTag()==0)
			{
				
				if(k.getArrTime()<=lastTime)
				{
					if(Min>k.getSerTime())
					{
						Min=k.getSerTime();
						ID=k.getID();
					}
				}
			}
			
		}
		return ID;
	}
	
	public void sjfSingle(SortedSet<Task> ts)
	{
		int lastTime=0;
		int ID;
		
		for(int i=0;i<100;i++)
		{	
			ID=findMin(ts,lastTime);
			lastTime=updateSingle(ts,ID,lastTime);
		}
	}
	public void sjfDouble(SortedSet<Task> ts)
	{
		int lastTime[]={0,0};
		int MinTime;
		int ID;
		
		for(int i=0;i<100;i++)
		{	
			if(lastTime[0]>lastTime[1])
				MinTime=lastTime[1];
			else MinTime=lastTime[0];
			ID=findMin(ts,MinTime);
			lastTime=updateDouble(ts,ID,lastTime);
		}
	}
	public void printDouble(SortedSet<Task> ts){
		Task t=new Task();
		Iterator<Task> iterator=ts.iterator();
		Iterator<Task> iterator1=ts.iterator();
		System.out.println("队列1");
		for(int i=0;i<100;i++)
		{
			t=iterator.next();
			if(t.getTag()==1)
				System.out.println(t.getID()+" "+t.getArrTime()+" "+t.getSerTime()+" "+t.getArrTime()+" "+t.getFinTime()+" "+t.getTurnAround()+" "+t.getWeight());
		}
		
		System.out.println("\n\n队列2");
		for(int i=0;i<100;i++)
		{
			t=iterator1.next();
			if(t.getTag()==2)
				System.out.println(t.getID()+" "+t.getArrTime()+" "+t.getSerTime()+" "+t.getArrTime()+" "+t.getFinTime()+" "+t.getTurnAround()+" "+t.getWeight());
		}
		
	}
}
