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
		System.out.print("�п�JB�n��J�h�֭Ӽ�:");
		k=sc.nextInt();
		for(int i=0;i<k;i++)
		{
			System.out.print("�п�JArrayList B������(���):");
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
		System.out.println("�R����");
		System.out.println(b+" �j�p��:"+b.size());
	}
	
}
