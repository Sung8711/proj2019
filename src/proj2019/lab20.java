package proj2019;
import java.util.*;
public class lab20 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		ArrayList<Float> a = new ArrayList<Float>();
		ArrayList<Float> b = new ArrayList<Float>();
//		int k;
//		float kb;
//		System.out.print("請輸入A要放入多少個數:");
//		k=sc.nextInt();
//		for(int i=0;i<k;i++)
//		{
//			System.out.print("請輸入ArrayList A中的值(浮點數):");
//			kb=sc.nextFloat();
//			a.add(kb);
//		}
//		System.out.println("---------插入排序前---------");
//		System.out.println(a);
//		System.out.println("---------插入排序後---------");
//		InsertionSort(a);
//		System.out.println(a);
		InputandInsert(b);
		System.out.println(b);
		
	}
	
//	public static void InsertionSort(ArrayList<Float> a)
//	{
//		float x;
//		int j;
//		for(int i=0;i<a.size();i++)
//		{
//			x=a.get(i);
//			for(j=i-1;j>=0 && a.get(j)>x;j--)
//			{
//				a.set(j+1, a.get(j));
//			}
//			a.set(j+1, x);
//		}
//	}
	
	public static void InputandInsert(ArrayList<Float> a)
	{
		float x,xx;
		int j=0;
		System.out.print("請輸入第1個浮點數:");
		x=sc.nextFloat();
		a.add(x);
		for(int i=1;i<6;i++)
		{
			System.out.print("請輸入第"+(i+1)+"個浮點數:");
			x=sc.nextFloat();
			for(j=0;j<i;j++)
			{
				if(x<a.get(j))
				{
					xx=a.get(j);
					a.set(j, x);
					x=xx;
				}
			}
			a.add(x);
		}
	}
	
}
