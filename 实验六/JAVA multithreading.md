# JAVA多线程
## 1.实验一
### Ⅰ.题目：
    对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
### Ⅱ.主要代码
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
    		System.out.print("正在请求填充...  ");
    		if(empty==false)
    			System.out.println("锅炉已有正在填充的进程");
    		else
    		{
    			System.out.println("填充过程进行成功");
    			empty=false;
    		}
    			
    	}
    	public synchronized void boil(){
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
    	public synchronized void drain(){
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
    	
### Ⅲ.实验结果截图
![image](https://note.youdao.com/yws/public/resource/120358c4940c4f4e4eaa35080299243c/xmlnote/66703BE89802411AAD73F2B835B813D8/443)

## 实验二
### Ⅰ.题目
    利用4个线程分段求和1~100
        线程1计算1~25之和；线程2计算26~50之和；以此类推
        要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
        打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果
### Ⅱ.主要代码
    public class Sum implements Runnable{
    	private static Thread[]sums=new Thread[4];
    	static int sum=0;
    	static int num=0;
    	private int threadID;
    	Sum(int id)
    	{
    		this.threadID=id;
    	}
    	public synchronized void doit(){
    		if(num<=100){
    			try{
    				
    				Thread.sleep(100);
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    			num++;
    		}
    	}
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		
    		int s=0;
    		for(int i=0;i<25;i++){
    			doit();
    			sum+=num;
    			s+=num;
    		}
    		
    		System.out.println("第"+threadID+"段:"+s);
    	}
    	public static void main(String [] args){
    		try{
    			for(int i=0;i<sums.length;i++){
    				sums[i]=new Thread(new Sum(i+1));
    				sums[i].start();
    				sums[i].join();
    			}
    		}catch(InterruptedException e){
    			System.out.println(e);
    		}
    		System.out.println("总和："+Sum.sum);
    	}
    }
### Ⅲ.实验结果截图
![image](https://note.youdao.com/yws/public/resource/120358c4940c4f4e4eaa35080299243c/xmlnote/59B67CA99B7049BCB62DCE3442A7A67F/454)
