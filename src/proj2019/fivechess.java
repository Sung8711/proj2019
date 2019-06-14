package proj2019;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.*;

public class fivechess extends JFrame
{
	private static chessboard ch ;
//	private static infopanel in = new infopanel();
	public fivechess(String s) throws IOException
	{
		setTitle("五子棋小遊戲"+"("+s+")");
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(ch,BorderLayout.CENTER);
//		add(in,BorderLayout.EAST);
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String S ;
		int op = JOptionPane.showConfirmDialog(null, "是否連線對戰？", "設定", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(op==JOptionPane.OK_OPTION)
		{
			S = "連線版";
			ch = new chessboard();
			fivechess jf = new fivechess(S);
		}
		if(op==JOptionPane.CLOSED_OPTION || op==JOptionPane.CANCEL_OPTION)
		{
			S = "單機版";
			ch = new chessboard();
			JFrame jf = new fivechess(S);
			JOptionPane.showMessageDialog(jf, "滑鼠左鍵為黑子，右鍵為白子");
			
		}
//		ch = new chessboard();
//		fivechess jf = new fivechess();
//		Thread thread = new Thread(ch);
		
	}
	
}

class chessboard extends JPanel implements Runnable 
{
	private MouseAdapter ma;
//	private DataInputStream fromServer;
//	private DataOutputStream toServer;
	private static boolean isconnect = false;
	private static int winplayer = 0;
	int count;
	int x=100;
	int y=100;
	int row=21;
	int interval=30;
	ArrayList<dot> bd = new ArrayList<dot>();
	ArrayList<dot> wd = new ArrayList<dot>();
	int [][] a = new int[row][row];
	int xxx,yyy;
	public chessboard()
	{
//		setLayout(new BorderLayout());
//		setTitle("五子棋對戰(可連線版)");
//		setSize(1000, 800);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ma = new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				dot d = new dot();
				dot d1 = new dot();
				int c = e.getButton();
				repaint();
				if(c==MouseEvent.BUTTON1)
				{
					if(e.getX()>=(x-(interval/2)) && e.getX()<=(x+(interval/2)+((row-1)*interval)))
					{
						if(e.getY()>=(y-(interval/2)) && e.getY()<=(y+(interval/2)+((row-1)*interval)))
						{
							xxx=((e.getX()-x)+(interval/2))/interval;
							yyy=((e.getY()-y)+(interval/2))/interval;
							d.setX(xxx);
							d.setY(yyy);
							if(overlapping(bd,d)==true)
							{
								bd.add(d);
								decide(bd,1,0);
								decide(bd,1,1);
								decide(bd,1,2);
								decide(bd,1,3);
							}
						}
					}
//					System.out.println("("+bd.get(0).getX()+","+bd.get(0).getY()+")");
//					System.out.println(bd.size());
				}
				if(c==MouseEvent.BUTTON3)
				{
					if(e.getX()>=(x-(interval/2)) && e.getX()<=(x+(interval/2)+((row-1)*interval)))
					{
						if(e.getY()>=(y-(interval/2)) && e.getY()<=(y+(interval/2)+((row-1)*interval)))
						{		
							xxx=((e.getX()-x)+(interval/2))/interval;
							yyy=((e.getY()-y)+(interval/2))/interval;
							d1.setX(xxx);
							d1.setY(yyy);
							if(overlapping(wd,d1)==true)
							{
								wd.add(d1);
								decide(wd,0,0);
								decide(wd,0,1);
								decide(wd,0,2);
								decide(wd,0,3);
							}
						}
					}
//					System.out.println("("+wd.get(0).getX()+","+wd.get(0).getY()+")");
//					System.out.println(wd.size());
				}
//				repaint();
			}
		};
		addMouseListener(ma);
	}
	public void decide(ArrayList<dot> d,int player,int cu )
	{
		int dx = 0;
		int dy = 0;
		if(cu==0)
		{
			dx = 1;
			dy = 0;
		}
		else if(cu==1)
		{
			dx = 0;
			dy = 1;
		}
		else if(cu==2)
		{
			dx = 1;
			dy = -1;
		}
		else if(cu==3)
		{
			dx = 1;
			dy = 1;
		}
		count = 1;
		for(int i=1;i<5;i++)
		{
			if(overlapping(d,new dot(xxx+(dx*i), yyy+(dy*i)))==false)
			{
				count++;
			}
			else
			{
				break;
			}
		}
		for(int i=1;i<5;i++)
		{
			if(overlapping(d,new dot(xxx-(dx*i), yyy-(dy*i)))==false)
			{
				count++;
			}
			else
			{
				break;
			}
		}
		if(count>=5)
		{
			if(player==0)
			{
				winplayer = 0;
				JOptionPane.showMessageDialog(null, "White win", "Game End", JOptionPane.INFORMATION_MESSAGE);
			}
			if(player==1)
			{
				winplayer = 1;
				JOptionPane.showMessageDialog(null, "Black win", "Game End", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public boolean overlapping(ArrayList<dot> d,dot dot)
	{
		for(int i=0;i<d.size();i++)
		{
			if(d.get(i).getX()==dot.getX() && d.get(i).getY()==dot.getY())
			{
				return false;
			}
		}
		return true;
	}
	public void paint(Graphics g)
	{
		//x,y起始座標(8,32)
		//g.fillOval(8, 32, 50, 50);
		//畫棋盤線
		for(int i=0;i<row;i++)
		{
			g.drawLine(x, y+(i*interval), x+((row-1)*interval), y+(i*interval));
			g.drawLine(x+(i*interval), y, x+(i*interval), y+((row-1)*interval));
		}
		for(int i=0;i<bd.size();i++)
		{
			g.fillOval((bd.get(i).getX()*interval)+x-(interval/2), (bd.get(i).getY()*interval)+y-(interval/2), 30, 30);
		}
		for(int i=0;i<wd.size();i++)
		{
			g.setColor(Color.WHITE);
			g.fillOval((wd.get(i).getX()*interval)+x-(interval/2), (wd.get(i).getY()*interval)+y-(interval/2), 30, 30);
			g.setColor(Color.BLACK);
			g.drawOval((wd.get(i).getX()*interval)+x-(interval/2), (wd.get(i).getY()*interval)+y-(interval/2), 30, 30);
		}
	}
	public static int getwin()
	{
		return winplayer;
	}
	public static boolean getConnet() 
	{
		return isconnect;
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
	}
	
}

class dot
{
	private int x = 0;
	private int y = 0;
	public dot(int dx,int dy)
	{
		this.x = dx;
		this.y = dy;
	}
	
	public dot()
	{
		
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
}