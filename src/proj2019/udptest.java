package proj2019;

import java.net.*;
import javax.swing.*;
import java.io.*;

public class udptest extends JFrame
{
	static int hport,mport;
	static String hip;
//	String msg="";
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		JTextField host = new JTextField("127.0.0.1");
		JTextField port = new JTextField("8080");
		JTextField myport = new JTextField("5566");
		int Port=0,P=0;
		String IP = "";
		String msg="hello";
//		int hip,hport,mport;
		InetAddress addr ;
		Object[] inputFields = 
						        {
						        	"對方IP",host,
						        	"對方Port",port,
						        	"自己Port",myport
						        };
		int op = JOptionPane.showConfirmDialog(null, inputFields, "連線設定", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(op==JOptionPane.OK_OPTION)
		{
			IP = host.getText();
			Port = Integer.parseInt(port.getText());
			P = Integer.parseInt(myport.getText());
		}
		if(op==JOptionPane.CLOSED_OPTION || op==JOptionPane.CANCEL_OPTION)
		{
			System.exit(0);
		}
		udptest u = new udptest(IP,Port,P);
		addr = InetAddress.getByName(IP);
		Thread t = new Thread(){
			public void run()
			{
				for(int i=1;;i++)
				{
					try {
						byte b[] = msg.getBytes();
						DatagramPacket dp = new DatagramPacket(b,b.length,addr,hport);
						DatagramSocket ds = new DatagramSocket();
						ds.send(dp);
						ds.close();
					}catch(Exception e) {
//						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(){
			public void run()
			{
				final int size = 8192;
				byte b[] = new byte[size];
				for(int i=1;;i++)
				{
					try {
						DatagramPacket dp1 = new DatagramPacket(b,b.length);
						DatagramSocket ds1 = new DatagramSocket(mport);
						ds1.setSoTimeout(1000);
						ds1.receive(dp1);
						String msg = new String(b,0,dp1.getLength());
						System.out.println(i+":"+msg);
						ds1.close();
					}catch(Exception e) {
//						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		t1.start();
	}
	public udptest(String s,int b,int c) throws IOException
	{
		hip = s;
		hport = b;
		mport = c;
	}
	
}
