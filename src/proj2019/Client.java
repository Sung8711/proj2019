package proj2019;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client 
{
	private ExecutorService exec= null;
	private Socket clientSocket = null;
	private DataInputStream fromServer;
	private DataOutputStream toServer;
	private static Scanner sc ;
	public Client()
	{
		exec = Executors.newCachedThreadPool();	
		exec.execute(new ClientSocket());
		while(true)
		{
			String m="";
			System.out.print("請輸入要說的東西:");
			m = sc.nextLine();
			try 
			{
				toServer.writeUTF(m);
				toServer.flush();
			} catch (UnknownHostException e1) 
			{
				e1.printStackTrace();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		Client c = new Client();
	}
	class ClientSocket implements Runnable
	{	
		@Override
		public void run() 
		{
			try 
			{
				clientSocket = new Socket("localhost", 8080);
				fromServer = new DataInputStream(clientSocket.getInputStream());
				toServer = new DataOutputStream(clientSocket.getOutputStream());	
				
				while (true) 
				{
					String msg = fromServer.readUTF();
					if (msg != null)
					{
						System.out.println(msg);
					}
				}
			} catch (UnknownHostException e) 
			{
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}			
		}
	}
}
