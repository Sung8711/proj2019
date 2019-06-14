package proj2019;

import java.util.ArrayList;
import java.util.Scanner;

public class lab17 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		int ka;
		for(int i=0;i<5;i++)
		{
			System.out.print("請輸入ArrayList A中的值(整數):");
			ka=sc.nextInt();
			a.add(ka);
		}
		b=a;
		a.set(3, 99);
		ArrayList<Integer> c = new ArrayList<Integer>(a);
		a.set(3, 199);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	
}
