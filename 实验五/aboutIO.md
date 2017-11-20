# 实验五
## 1.基本IO操作
### a.题目
    从键盘接收字节流
    写入到当前目录下的src.txt文件中
    将src.txt文件内容复制到当前目录下dest.txt文件中
    将dest.txt文件内容显示到屏幕上
    
### b.主要代码
     try {  
	    	
	        PrintWriter fout=new PrintWriter(out);
	        System.out.println("please Input:");  
	        do{  
	        	b = scan.nextLine();
	        	
	            fout.write(b+"\r\n");
	        }while (!b.equals(" "));
	        
	        fout.close();
	        scan.close();
	  
	        Reader finS = new FileReader(out);  
	        PrintWriter foutS=new PrintWriter(outFile);
	        BufferedReader br=new BufferedReader(finS);  
	        
	        while ((b= br.readLine())!=null){  
	        	
	            foutS.write(b+"\r\n");  
	        }
	        
	        finS.close();
	        foutS.close();
	    } catch (IOException e) {  
	        System.out.println(e.toString());  
	    }  
    
### c.实验截图
#### ①键盘输入字符串
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/505092008CE240C691455065407AF68A/32)
#### ②src.txt及dest.txt
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/2E0C16C633564FA68C8E52C414AFCC88/42)

## 2.获取系统的文件树
### a.题目
    获取某个目录下的目录信息，目录从控制台输入。
    目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
    目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
### b.主要代码
    public void print(File f) {
        if (f != null) 
        {

            	TreeSet ts=new TreeSet(new MyComparator());
            	File t;
                File [] arr = f.listFiles();
                File out=new File("filename.txt");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                
                if (arr != null)
                {
                	for(int i=0;i<arr.length;i++)
                	{

                			ts.add(arr[i]);
                	}
                	
                	try{
                		PrintWriter fout=new PrintWriter(out);
                		Iterator it1=ts.iterator();
                    	Iterator it2=ts.iterator();
	                	String b;
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it1.next();
	                    	if (t.isDirectory()) 
	                        {
		                    	System.out.println(b=(t.getName()+"\t修改时间："+df.format( new Date(t.lastModified()))));
		                    	fout.write(b+"\r\n");
	                    		
	                        }
	                    }
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it2.next();
	                    	if (!t.isDirectory()) 
	                        {
	                    		
	                    		
	                            System.out.println(b=(t.getName()+"\t大小:"+t.length()+"字节"+"\t修改时间："+df.format( new Date(t.lastModified()))));
	                            fout.write(b+"\r\n");
	                        }
	                    }
	                	fout.close();
                	}catch (IOException e){
                		System.out.println(e.toString());
                	}
                }
             
                
        }
	}
	
### c.实验截图
#### ①键盘输入地址
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/021167EEA84B4065BFAA1352C588F5A4/64)
#### ②filename.txt文件
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/DA4572445CF149049104C038E039E896/69)
## 3.带缓冲区的IO
### a.题目
    用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
### b.主要代码
    public class IOcompare {
    	public void withoutBuffer(){
    		try{
    			int c;
    			File inFile=new File("iris.txt");
    			File outFile=new File("withoutBuffer.txt");
    			Reader finS=new FileReader(inFile);
    			Writer foutS=new FileWriter(outFile);
    			while((c=finS.read())!=-1)
    			{
    				foutS.write(c);
    			}
    			foutS.close();
    			finS.close();
    		}catch(IOException e){
    			System.err.println("FileStreamTest:"+e);
    		}
    	}
    	public void withBuffer(){
    		try{
    			int c;
    			File inFile=new File("iris.txt");
    			File outFile=new File("withBuffer.txt");
    			Reader finS=new FileReader(inFile);
    			Writer foutS=new FileWriter(outFile);
    			BufferedReader bfinS=new BufferedReader(finS);
    			BufferedWriter bfoutS=new BufferedWriter(foutS);
    			while((c=bfinS.read())!=-1)
    			{
    				bfoutS.write(c);
    			}
    			bfoutS.close();
    			bfinS.close();
    		}catch(IOException e){
    			System.err.println("FileStreamTest:"+e);
    		}
    	}
    	public static void main(String [] args)
    	{
    		IOcompare io=new IOcompare();
    		long startTime = System.currentTimeMillis();
    		io.withoutBuffer();
    		long endTime = System.currentTimeMillis();
    		System.out.println("copy file without Buffer:"+(endTime-startTime)+"ms");
    		long startTime1 = System.currentTimeMillis();
    		io.withBuffer();
    		long endTime1 = System.currentTimeMillis();
    		System.out.println("copy file with Buffer:"+(endTime1-startTime1)+"ms");
    	}
    }

### c.实验截图
#### ①运行结果
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/86EF23C2253C4AA6BD478C00A8DD3751/161)
#### ②原文件及复制文件
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/7E0134ADEF7E49D1BEE31050C4416153/190)

## 4.对象序列化
### a.题目
    类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
    使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
    使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
### b.主要代码
    public class SerializationObject {
    	public void readFile(SortedSet<Student> ts)throws Exception
    	{
    		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("list.txt"),"UTF-8"));
    		String s;
    		while((s=br.readLine())!=null){
    			
    			String [] str=s.split(" ");
    			
    			Student t=new Student(Long.parseLong(str[0]),str[1],str[2]);
    			
    			ts.add(t);
    		}
    
    		br.close();
    	}
    	public void ObjectIO(SortedSet<Student> ts)throws Exception
    	{
    		Student s=new Student();
    		Student t=null;
    		String filename = "student.bin";
    		FileOutputStream fos = null;
    		ObjectOutputStream out = null;
    		FileInputStream fis = null;
    		ObjectInputStream in = null;
    		try {
    			fos = new FileOutputStream(filename);
    			out = new ObjectOutputStream(fos);
    			Iterator it=ts.iterator();
    			while(it.hasNext())
    			{
    				out.writeObject((Student)it.next());
    			}
    			out.writeObject(t);
    			out.close();
    			fis = new FileInputStream(filename);
    			in = new ObjectInputStream(fis);
    			while((s=(Student)in.readObject())!=null){
    				System.out.println(s.getNumber() + " " + s.getName()+" "+s.getSex());
    			}
    			in.close();
    		} catch (IOException ex) {
    			   ex.printStackTrace();
    		}
    
    	}
    }

### c.实验截图
![image](https://note.youdao.com/yws/public/resource/8ef52e2eed6aa2fb7472f8089bd06f87/xmlnote/B52EA76C1B0F4C63ABDDB345608FC29A/179)
