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
		System.out.print("�п�JA���j�p:");
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
			System.out.print("�п�JA�x�}��(���):");
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
		System.out.print("�п�JB�n��J�h�֭Ӽ�:");
		k=sc.nextInt();
		for(int i=0;i<k;i++)
		{
			System.out.print("�п�JArrayList B������(���):");
			kb=sc.nextInt();
			b.add(kb);
		}
		System.out.println(b);
	}
	
}
