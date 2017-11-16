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