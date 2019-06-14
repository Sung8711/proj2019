package proj2019;
import java.util.*;
public class Lab26 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<card> cardbox = new ArrayList<card>();
//		ArrayList<ArrayList<card>> cardpairs = new ArrayList<ArrayList<card>>();
		ArrayList<card> p1 = new ArrayList<card>();
		ArrayList<card> p2 = new ArrayList<card>();
		ArrayList<card> p3 = new ArrayList<card>();
		ArrayList<card> p4 = new ArrayList<card>();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
			{
				if(i==0)
				{
					card c = new card(j+1,"�®�");
					cardbox.add(c);
					
				}
				if(i==1)
				{
					card c = new card(j+1,"����");
					cardbox.add(c);
				}
				if(i==2)
				{
					card c = new card(j+1,"���j");
					cardbox.add(c);
				}
				if(i==3)
				{
					card c = new card(j+1,"����");
					cardbox.add(c);
				}
			}
		}
		shuffle(cardbox);
		licensing(cardbox,p1,p2,p3,p4);
		System.out.println("�Ĥ@�쪱�a����P");traversal(p1);
		System.out.println("���a�N��P�Ƨǫ�:");
		traversal(InsertionSort(p1));
		System.out.print("�Ĥ@�쪱�a��");findpairs(InsertionSort(p1));
		System.out.println("�ĤG�쪱�a����P");traversal(p2);
		System.out.println("���a�N��P�Ƨǫ�:");
		traversal(InsertionSort(p2));
		System.out.print("�ĤG�쪱�a��");findpairs(InsertionSort(p2));
		System.out.println("�ĤT�쪱�a����P");traversal(p3);
		System.out.println("���a�N��P�Ƨǫ�:");
		traversal(InsertionSort(p3));
		System.out.print("�ĤT�쪱�a��");findpairs(InsertionSort(p3));
		System.out.println("�ĥ|�쪱�a����P");traversal(p4);
		System.out.println("���a�N��P�Ƨǫ�:");
		traversal(InsertionSort(p4));
		System.out.print("�ĥ|�쪱�a��");findpairs(InsertionSort(p4));
	}
	public static ArrayList<card> InsertionSort(ArrayList<card> a)
	{
		ArrayList<card> b = new ArrayList<card>();
		card x;
		b.add(a.get(0));
		for(int i=1;i<a.size();i++)
		{
			x=a.get(i);
			for(int j=0;j<b.size();j++)
			{
				if(b.get(j).point>x.point)
				{
					b.add(j, x);
					break;
				}
				else if(b.get(j).point==x.point)
				{
					if(b.get(j).getsuitnum()>x.getsuitnum())
					{
						b.add(j, x);
						break;
					}
				}
				else if(j==b.size()-1)
				{
					b.add(x);
				}
			}
		}
		return b;
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
	public static void licensing(ArrayList<card> a,ArrayList<card> p1,ArrayList<card> p2,ArrayList<card> p3,ArrayList<card> p4)
	{
		for(int i=0;i<a.size();i=i+4)
		{
			p1.add(a.get(i));
			p2.add(a.get(i+1));
			p3.add(a.get(i+2));
			p4.add(a.get(i+3));
		}
	}
	public static void findpairs(ArrayList<card> a)
	{
		ArrayList<card> p = new ArrayList<card>();
		for(int i=0;i<a.size();i++)
		{
			for(int j=i+1;j<a.size();j++)
			{
				if(a.get(i).point==a.get(j).point)
				{
					p.add(a.get(i));
					p.add(a.get(j));
				}
				else if(a.get(i).point!=a.get(j).point)
				{
					break;
				}
			}
		}
		for(int i=0;i<p.size();i=i+2)
		{
			System.out.print("pairs:"+p.get(i).suit+" "+p.get(i).point+" "+p.get(i+1).suit+" "+p.get(i+1).point+"\t");
		}
		System.out.println("");
	}
	
}
