package proj2019;
import java.util.*;
import java.io.*;
public class b0543005_Lab1 
{
	public static String FilePath="C:\\Users\\MMLAB\\Desktop\\DB.csv";
	public static ArrayList<ArrayList<Integer>> DB = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(FilePath);
		BufferedReader bfr = new BufferedReader(fr);
		String record;
		while ((record = bfr.readLine())!=null)
		{
			String item[] = record.split(",");
			ArrayList<Integer> List = new ArrayList<Integer>();
			for(int i=0;i<item.length;i++)
			{
				item[i]=item[i].replace("\"", "");
				List.add(Integer.valueOf(item[i]));
			}
			DB.add(List);
		}
		System.out.println(DB);
		int a[][] = new int [DB.size()][DB.get(0).size()];
		for(int i=0;i<DB.size();i++)
		{
			for(int j=0;j<DB.get(i).size();j++)
			{
				a[i][j] = DB.get(i).get(j);
			}
		}
		int b[][] = new int [DB.get(0).size()][DB.size()];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+" ");
				b[j][i] = a[i][j];
			}
			System.out.println();
		}
		System.out.println("");
		FileWriter fw = new FileWriter("C:\\Users\\MMLAB\\Desktop\\DBT.txt");
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				System.out.print(b[i][j]+" ");
				fw.write(b[i][j]+" ");
			}
			System.out.println();
			fw.write("\r\n");
		}
		fw.flush();
		fr.close();
		bfr.close();
		fw.close();
	}
}
