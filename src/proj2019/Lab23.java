package proj2019;
import java.util.*;
public class Lab23 
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
//		traversal(cardbox);
//		System.out.println(cardbox.size());
		shuffle(cardbox);
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
	public static void shuffle(ArrayList<card> a)
	{
		for(int i=0;i<a.size();i++)
		{
			swap(a,i,(int)(Math.random()*a.size()-1));
		}
	}
	public static void swap(ArrayList<card> a, int x, int y)
	{
		card temp;
		temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
	}

}
