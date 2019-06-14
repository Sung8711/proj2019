package proj2019;
import java.util.*;
public class lab15 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n;
		ArrayList<Integer> b = new ArrayList<Integer>();
		System.out.print("請輸入A的大小:");
		n=sc.nextInt();
		int a[]=new int[n];
		setandprintA(a);
		setandprintB(b);
	}
	
	public static void setandprintA(int a[])
	{
		int na;
		for(int i=0;i<a.length;i++)
		{
			System.out.print("請輸入A矩陣值(整數):");
			na=sc.nextInt();
			a[i]=na;
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	
	public static void setandprintB(ArrayList<Integer> b)
	{
		int k,kb;
		System.out.print("請輸入B要放入多少個數:");
		k=sc.nextInt();
		for(int i=0;i<k;i++)
		{
			System.out.print("請輸入ArrayList B中的值(整數):");
			kb=sc.nextInt();
			b.add(kb);
		}
		System.out.println(b);
	}
	
}
