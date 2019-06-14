package proj2019;
import java.util.*;
public class lab18 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k,kb;
		ArrayList<Integer> b = new ArrayList<Integer>();
		System.out.print("請輸入B要放入多少個數:");
		k=sc.nextInt();
		for(int i=0;i<k;i++)
		{
			System.out.print("請輸入ArrayList B中的值(整數):");
			kb=sc.nextInt();
			b.add(kb);
		}
//		for(int i=0;i<b.size();i++)
//		{
//			b.remove(i);
//			i--;
//		}
		for(;b.size()!=0;)
		{
			b.remove(0);
		}
//		for(int i=0;i<k;i++)
//		{
//			b.remove(0);
//		}
		System.out.println("刪除後");
		System.out.println(b+" 大小為:"+b.size());
	}
	
}
