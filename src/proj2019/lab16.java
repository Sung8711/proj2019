package proj2019;
import java.util.*;
public class lab16 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n,na,at;
		ArrayList<Integer> b = new ArrayList<Integer>();
		System.out.print("請輸入A的大小:");
		n=sc.nextInt();
		int a[]=new int[n];
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
		System.out.print("請輸入要搜尋的值:");
		at=sc.nextInt();
		decide(findtargetA(a,at));
		int k,kb,bt;
		System.out.print("請輸入B要放入多少個數:");
		k=sc.nextInt();
		for(int i=0;i<k;i++)
		{
			System.out.print("請輸入ArrayList B中的值(整數):");
			kb=sc.nextInt();
			b.add(kb);
		}
		System.out.print("請輸入要搜尋的值:");
		bt=sc.nextInt();
		decide(findArrattarget(b,bt));
	}
	
	public static int findtargetA(int a[], int at)
	{
		int index=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==at)
			{
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public static int findArrattarget(ArrayList<Integer> b, int bt)
	{
		for(int i=0;i<b.size();i++)
		{
			if(b.get(i)==bt)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void decide(int x)
	{
		if(x>-1)
		{
			System.out.println("Index:"+x);
		}
		else
		{
			System.out.println("No exist");
			System.out.println(x);
		}
	}
}
