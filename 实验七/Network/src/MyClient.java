import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;



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
