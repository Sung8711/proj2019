package proj2019;
import java.util.*;
public class lab19 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		ArrayList<String> d = new ArrayList<String>();
		a.add("1");a.add("3");a.add("5");a.add("8");a.add("9");a.add("26");a.add("33");
		System.out.println(a);
		b.add("3");b.add("5");b.add("11");b.add("15");b.add("26");
		System.out.println(b);
		AandB(a,b,c);
		System.out.println(c);
		AorB(a,b,d);
		System.out.println(d);
	}
	
	public static void AandB(ArrayList<String> a,ArrayList<String> b,ArrayList<String> c)
	{
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<b.size();j++)
			{
				if(a.get(i).equals(b.get(j)))
				{
					c.add(a.get(i));
				}
			}
		}
	}
	
	public static void AorB(ArrayList<String> a,ArrayList<String> b,ArrayList<String> d)
	{
		int i=0,j=0;
		while(i<a.size() && j<b.size())
		{
			if(Integer.valueOf(a.get(i))<Integer.valueOf(b.get(j)))
			{
				if(d.contains(a.get(i))==false)
				{
					d.add(a.get(i));
				}
				i++;
			}
			else
			{
				if(d.contains(b.get(j))==false)
				{
					d.add(b.get(j));
				}
				j++;
			}
		}
		while(i<a.size())
		{
			if(d.contains(a.get(i))==false)
			{
				d.add(a.get(i));
			}
			i++;
		}
		while(j<b.size())
		{
			if(d.contains(b.get(j))==false)
			{
				d.add(b.get(j));
			}
			j++;
		}
	}
	
}
