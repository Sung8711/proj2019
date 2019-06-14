package proj2019;
import java.io.*;
import java.util.*;
public class Leb14 
{
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		MergeOperation();
	}
	public static void MergeOperation() throws IOException
	{
		FileReader fr=new FileReader("C:\\Users\\MMLAB\\Documents\\SeqA.txt");
		FileReader fr1=new FileReader("C:\\Users\\MMLAB\\Documents\\SeqB.txt");
		BufferedReader bfr=new BufferedReader(fr);
		BufferedReader bfr1=new BufferedReader(fr1);
		int ans[] = new int[0];
		int tmpans[] = new int[0];
		int count = 0;
		boolean end = true;
		String str1="", str2=""; 
		do
		{
			if(end!=false) 
			{
				str1=bfr.readLine();
				str2=bfr1.readLine();
				end = !end;
			}
			
			if(Integer.parseInt(str1)<=Integer.parseInt(str2)) 
			{
				count++;
				tmpans = new int[ans.length];
				for(int i=0;i<ans.length;i++)
				{
					tmpans[i]=ans[i];
				}
				ans = new int[count];
				for(int i=0;i<tmpans.length;i++)
				{
					ans[i]=tmpans[i];
				}
				ans[count-1] = Integer.parseInt(str1);
				str1=bfr.readLine();
			}
			else 
			{
				count++;
				tmpans = new int[ans.length];
				for(int i=0;i<ans.length;i++)
				{
					tmpans[i]=ans[i];
				}
				ans = new int[count];
				for(int i=0;i<tmpans.length;i++)
				{
					ans[i]=tmpans[i];
				}
				ans[count-1] = Integer.parseInt(str2);
				str2=bfr1.readLine();
			}
		}while(bfr1.ready() && bfr.ready());
		do 
		{
			count++;
			tmpans = new int[ans.length];
			for(int i=0;i<ans.length;i++)
			{
				tmpans[i]=ans[i];
			}
			ans = new int[count];
			for(int i=0;i<tmpans.length;i++)
			{
				ans[i]=tmpans[i];
			}
			ans[count-1] = Integer.parseInt(str1);
			str1=bfr.readLine();
		}while(str1!=null);
		do 
		{
			count++;
			tmpans = new int[ans.length];
			for(int i=0;i<ans.length;i++)
			{
				tmpans[i]=ans[i];
			}
			ans = new int[count];
			for(int i=0;i<tmpans.length;i++)
			{
				ans[i]=tmpans[i];
			}
			ans[count-1] = Integer.parseInt(str2);
			str2=bfr1.readLine();
		}while(str2!=null);
		System.out.print("[");
		for(int i=0;i<ans.length;i++)
		{
			System.out.print(ans[i]+" ");
		}
		System.out.print("]");
		bfr.close();
		bfr1.close();
		fr.close();
		fr1.close();
	}
}
