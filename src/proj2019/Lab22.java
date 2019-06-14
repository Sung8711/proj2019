package proj2019;
import java.util.*;
public class Lab22 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<card> cardbox = new ArrayList<card>();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
			{
				if(i==0)
				{
					card c = new card(j+1,"¶Â®ç");
					cardbox.add(c);
					
				}
				if(i==1)
				{
					card c = new card(j+1,"¬õ¤ß");
					cardbox.add(c);
				}
				if(i==2)
				{
					card c = new card(j+1,"¬õ¿j");
					cardbox.add(c);
				}
				if(i==3)
				{
					card c = new card(j+1,"±öªá");
					cardbox.add(c);
				}
			}
		}
		traversal(cardbox);
	}
	public static void traversal(ArrayList<card> a)
	{
		int count=0;
		for(int i=0;i<a.size();i++)
		{
			System.out.print(a.get(i).suit+" "+a.get(i).point+" ");
			if(count==12)
			{
				System.out.println("");
				count=0;
			}
			else
			{
				count++;
			}
			
		}
	}
	
}
class card
{
	int point;
	String suit;
	public card(int x,String s)
	{
		point = x;
		suit  = s;
	}
	public int getsuitnum()
	{
		if(suit=="¶Â®ç")
		{
			return 4;
		}
		else if(suit=="¬õ¤ß")
		{
			return 3;
		}
		else if(suit=="¬õ¿j")
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
}
