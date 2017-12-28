# JAVA 网络编程
## Ⅰ.题目
    改造教材19.2和19.3的例子，创建简单的聊天程序
        服务器也具有类似客户端的UI界面
        服务器也能够向客户端发送信息
        客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录
## Ⅱ.主要代码
### ①MyTcp
    public class MyTcp extends JFrame{
    	private BufferedReader reader;
    	private ServerSocket server;
    	private Socket socket;
    	
    	JTextPane textPane = new JTextPane();
    	JPanel contPane = new JPanel(); 
    	
    	private PrintWriter writer;
    //	private JTextArea ta=new JTextArea();
    	private JTextField tf=new JTextField();
    	Container cc;
    	public MyTcp(){
    		super("DocColorTest");
    		
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		cc=this.getContentPane();
    		final JScrollPane scrollPane=new JScrollPane();
    		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
    		getContentPane().add(scrollPane, BorderLayout.CENTER);
    		//scrollPane.setViewportView(ta);
    		
    		
    
    		cc.setLayout(new BorderLayout());
    		cc.add(new JScrollPane(textPane),"Center");
    		setContentPane(cc);
    		setVisible(true);
    		cc.add(tf, "South");
    		tf.addActionListener(new ActionListener(){
    
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				writer.println(tf.getText());
    				insertDocument(tf.getText()+'\n',Color.red);
    //				ta.append(tf.getText()+'\n');
    //				ta.setSelectionEnd(ta.getText().length());
    				tf.setText("");
    			}
    			
    		});
    	}
    	void getserver(){
    		try{
    			server=new ServerSocket(8898);
    			insertDocument("套接字创建成功！\n",Color.black);
    //			ta.append("套接字创建成功！\n");
    			while(true){
    				insertDocument("等待客户机的响应！\n",Color.black);
    //				ta.append("等待客户机的响应！\n");
    				socket=server.accept();
    				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    				writer=new PrintWriter(socket.getOutputStream(),true);
    				getClientMessage();
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	public void insertDocument(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
    	{
    		SimpleAttributeSet set = new SimpleAttributeSet();
    		StyleConstants.setForeground(set, textColor);//设置文字颜色
    		StyleConstants.setFontSize(set, 12);//设置字体大小
    		Document doc = textPane.getStyledDocument();
    		try{
    			doc.insertString(doc.getLength(), text, set);//插入文字
    		}catch (BadLocationException e){
    			e.printStackTrace();
    		}
    	}
    	
    	private void getClientMessage(){
    		try{
    			while(true){
    //				ta.append("客户机:"+reader.readLine()+'\n');
    				insertDocument("客户机:"+reader.readLine()+'\n',Color.blue);
    				
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		try{
    			if(reader!=null){
    				reader.close();
    			}
    			if(socket!=null){
    				socket.close();
    			}
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    	public static void main(String[] args){
    		MyTcp tcp=new MyTcp();
    		tcp.setSize(200,200);
    		tcp.setVisible(true);
    		tcp.getserver();
    	}
    }
### ②MyClient
    public class MyClient extends JFrame{
    	private PrintWriter writer;
    	Socket socket;
    	//private JTextArea ta=new JTextArea();
    	private JTextField tf=new JTextField();
    	Container cc;
    	JTextPane textPane = new JTextPane();
    	JPanel contPane = new JPanel();  
    	private BufferedReader reader;
    	
    	
    	public MyClient(){
    		super("DocColorTest");
    		
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		cc=this.getContentPane();
    		final JScrollPane scrollPane=new JScrollPane();
    		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
    		getContentPane().add(scrollPane, BorderLayout.CENTER);
    		//scrollPane.setViewportView(ta);
    		
    		
    
    		cc.setLayout(new BorderLayout());
    		cc.add(new JScrollPane(textPane),"Center");
    		setContentPane(cc);
    		setVisible(true);
    		cc.add(tf, "South");
    		tf.addActionListener(new ActionListener(){
    
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				writer.println(tf.getText());
    				insertDocument(tf.getText()+'\n',Color.blue);
    				//ta.append(tf.getText()+'\n');
    				//ta.setSelectionEnd(ta.getText().length());
    				tf.setText("");
    			}
    			
    		});
    	}
    	public void insertDocument(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
    	{
    		SimpleAttributeSet set = new SimpleAttributeSet();
    		StyleConstants.setForeground(set, textColor);//设置文字颜色
    		StyleConstants.setFontSize(set, 12);//设置字体大小
    		Document doc = textPane.getStyledDocument();
    		try{
    			doc.insertString(doc.getLength(), text, set);//插入文字
    		}catch (BadLocationException e){
    			e.printStackTrace();
    		}
    	}
    
    	private void getTCPMessage(){
    		try{
    			while(true){
    				
    				//ta.append("服务器:"+reader.readLine()+'\n');
    				insertDocument("服务器："+reader.readLine()+'\n',Color.red);
    				
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		try{
    			if(reader!=null){
    				reader.close();
    			}
    			if(socket!=null){
    				socket.close();
    			}
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    	private void connect(){
    		//ta.append("尝试连接\n");
    		insertDocument("尝试连接\n",Color.black);
    		try{
    			socket=new Socket("127.0.0.1",8898);
    			writer=new PrintWriter(socket.getOutputStream(),true);
    			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    			//ta.append("完成连接！\n");
    			insertDocument("完成连接!\n",Color.black);
    			getTCPMessage();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		
    	}
    	public static void main(String[] args){
    		MyClient client=new MyClient();
    		client.setSize(200,200);
    		client.setVisible(true);
    		client.connect();
    	}
    	
    }
## Ⅲ.实验结果截图
![image](https://note.youdao.com/yws/public/resource/8ede813c7b51f08e681576064a8727ba/xmlnote/19AA61AC99F4495EA73AFB450F654721/488)

![image](https://note.youdao.com/yws/public/resource/8ede813c7b51f08e681576064a8727ba/xmlnote/315AD4244BA6409BACB36CB33F7AA93F/490)