import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

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
