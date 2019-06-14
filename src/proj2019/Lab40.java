package proj2019;

import java.io.*;
import java.util.*;

public class Lab40 
{
	public static String fp = "C:\\Users\\MMLAB\\Desktop\\testDB.txt";
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		ArrayList[] DB = new ArrayList[27];
		for(int i=0;i<DB.length;i++)
		{
			DB[i] = new ArrayList<Integer>();
		}
		loadfile(fp,DB);
		for(int i=0;i<DB.length;i++)
		{
			if(!DB[i].isEmpty())
			{
				System.out.print(String.format("%1$02d", i)+"\t"+(char)(i+64)+"\t");
			}
			for(int j=0;j<DB[i].size();j++)
			{
				System.out.print(DB[i].get(j)+" ");
			}
			if(!DB[i].isEmpty())
			{
				System.out.println();
			}
		}
	}
	public static void loadfile(String s,ArrayList[] a) throws IOException
	{
		FileReader fr = new FileReader(s);
		BufferedReader bfr = new BufferedReader(fr);
		int count = 1 ;
		String record;
		while((record=bfr.readLine())!=null)
		{
			String[] data = record.split(" ");
			for(int i=0;i<data.length;i++)
			{
				for(int j=0;j<data[i].length();j++)
				{
					a[(int)data[i].charAt(j)-64].add(count);
				}
			}
			count++;
		}
	}
	
}
