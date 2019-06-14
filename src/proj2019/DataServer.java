package proj2019;

import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DataServer 
{
	private ServerSocket serverSocket = null;
	private static Map<Socket, Integer> list = new LinkedHashMap<Socket,Integer>();
	private ExecutorService exec= null;
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
//		try {
//			InetAddress a = InetAddress.getLocalHost();
//			System.out.println(a.getClass());
//			System.out.println(a.getHostAddress().getClass());
//		}catch(UnknownHostException e) {
//			e.printStackTrace();
//		}
		DataServer ds = new DataServer();
	}
	public DataServer() throws IOException
	{
		serverSocket = new ServerSocket(8080);
		exec = Executors.newCachedThreadPool();
		while(true)
		{
			Socket socket = null;
			socket = serverSocket.accept();
			System.out.println(1);
			list.put(socket,socket.getPort());
			exec.execute(new Communication(socket));
		}
	}
	public class Communication implements Runnable
	{
		private Socket socket;
		//�Ω󱵦��q�Ȥ�ݶǰe�L�Ӫ���T
		private DataInputStream fromClient =null;
		//�Ω�V�Ȥ�ݶǰe��T
		private DataOutputStream toClient = null;
		private String msg;
		private boolean first = true;
		public Communication(Socket socket) throws IOException
		{
			this.socket = socket;
			fromClient = new DataInputStream(socket.getInputStream());
			msg ="["+socket.getPort()+ "]�w�s�u����A��\n";
//			txt1.append(msg+"\n");
			System.out.println(msg);
//			sendMessage();
			
//			send.addActionListener(new ActionListener()
//			{
//				@Override
//				public void actionPerformed(ActionEvent e) 
//				{
//					msg = edt.getText()+"\n";
//					txt1.append(msg);
//					sendMessage();
//					edt.setText("");
//				}
//			});
		}
		@Override
		public void run()
		{
			try 
			{
				while((msg= fromClient.readUTF())!=null)
				{
//					"[" + socket.getPort() + "]:"
//					txt1.append(msg+"\n");
					sendMessage();
				}
			} catch (Exception e) 
			{
			}
		}
		//�N�q�ȪA�ݱ����쪺��T,�j��ǰe��Ҧ��Ȥ��
		public void sendMessage()  
		{
			
			Iterator it = list.entrySet().iterator();
			while (it.hasNext()) 
			{
				Entry entry = (Entry) it.next();
				Socket client =(Socket) entry.getKey();
				int port = (Integer) entry.getValue();
				//�p�G�����Ȥ�������F,���B�p�G��throws exception��ƱN�L�k�ǰe���Ȥ��,��try catch�i�H�~��q�T
				try
				{
					toClient = new DataOutputStream(client.getOutputStream());
					toClient.writeUTF(msg);	
				} catch (IOException e) 
				{
					e.printStackTrace();
				}					
			}
		}
		
	}
	
}
