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
	
	public int[] updateDouble(SortedSet<Task> ts,int ID,int [] lastTime,int tag)
	{
		int lastT=lastTime[tag-1];
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
		if(t.getArrTime()>lastT)
			t.setStart(t.getArrTime());
		else
			t.setStart(lastT);
		t.setTag(tag);
		t.setFinish(t.getStartTime()+t.getSerTime());
		t.setTurnAround(t.getFinTime()-t.getArrTime());
		t.setWeight((double)t.getTurnAround()/t.getSerTime());
		lastT=t.getFinTime();

		lastTime[tag-1]=lastT;
		return lastTime;
		
	}
	
	public int findMin(SortedSet<Task> ts,int lastTime)
	{
		Task k=new Task();
		Task t=new Task();
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
		if(ID==0)
		{
			Iterator<Task> it=ts.iterator();
			for(int i=0;i<100;i++)
			{
				t=it.next();
				if(t.getTag()==0)
				{
					ID=t.getID();
					break;
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
		int nextTag=0;
		for(int i=0;i<100;i++)
		{	
			if(lastTime[0]<lastTime[1])
			{
				MinTime=lastTime[0];
				nextTag=1;
			}
			else 
			{
				MinTime=lastTime[1];
				nextTag=2;
			}
			
			ID=findMin(ts,MinTime);
			lastTime=updateDouble(ts,ID,lastTime,nextTag);
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
