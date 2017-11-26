
public class Task implements Comparable<Task>{
	private int taskID;
	private int arrivalTime;
	private int serviceTime;
	private int startingTime;
	private int finishingTime;
	private int turnAroundTime;
	private double weightTurnAround;
	private int tag;
	Task(){
	}
	Task(int id,int arTime,int serTime){
		this.taskID=id;
		this.arrivalTime=arTime;
		this.serviceTime=serTime;
		this.startingTime=0;
		this.finishingTime=0;
		this.turnAroundTime=0;
		this.weightTurnAround=0;
		this.tag=0;
	}
	public int getID(){
		return taskID;
	}
	public int getArrTime()
	{
		return arrivalTime;
	}
	public int getSerTime(){
		return serviceTime;
	}
	public int getStartTime(){
		return startingTime;
	}
	
	public int getFinTime(){
		return finishingTime;
	}
	public int getTurnAround(){
		return turnAroundTime;
	}
	public double getWeight()
	{
		return weightTurnAround;
	}
	public int getTag(){
		return tag;
	}
	public void setStart(int start){
		this.startingTime=start;
	}
	public void setFinish(int finish){
		this.finishingTime=finish;
	}
	public void setTurnAround(int turnAround)
	{
		this.turnAroundTime=turnAround;
	}
	public void setWeight(double weightTurnA){
		this.weightTurnAround=weightTurnA;
	}
	public void setTag(int tag)
	{
		this.tag=tag;
	}
	public int compareTo(Task t)
	{
		return Integer.compare(taskID, t.taskID);
	}
	public String toString()
	{
		return taskID+"  "+arrivalTime+"  "+serviceTime+"  "+startingTime+"  "+finishingTime+"  "+turnAroundTime+"  "+weightTurnAround+"\n";
	}
}
