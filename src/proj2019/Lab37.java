package proj2019;

import java.util.*;
import java.io.*;

public class Lab37 
{
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int target;
		System.out.print("請輸入要搜尋的節點:");
		target = sc.nextInt();
		tree x = new tree(-1);
		treenode t = x.root;
		String fp = "C:\\Users\\MMLAB\\Desktop\\data.txt";
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		String record;
		boolean b=false;
		while((record=bfr.readLine())!=null)
		{
			treenode c = t;
			String data[] = record.split(" ");
			for(int i=0;i<data.length;i++)
			{
				for(int j=0;j<c.child.size();j++)
				{
					if(Integer.parseInt(data[i])==c.child.get(j).value)
					{
						c.child.get(j).time++;
						c = c.child.get(j);
						b=true;
					}
				}
				if(b==false)
				{
					c.child.add(new treenode(Integer.parseInt(data[i])));
					c = c.child.get(c.child.size()-1);
				}
				else
				{
					b=false;
				}
			}
		}
		System.out.println("target="+target+"\n"+"樹狀結構中有"+x.traverse(t,target)+"個節點");
		fr.close();
		bfr.close();
		sc.close();
	}

	public static class treenode
	{
		int value,time;
		ArrayList<treenode> child;
		treenode(int v)
		{
			value = v;
			time = 1;
			child = new ArrayList<treenode>();
		}
	}
	
	public static class tree
	{
		treenode root;
		tree(int v)
		{
			root = new treenode(v);
		}
		
		static int t = 0;
		static int Level = 1;
		static boolean first = true;
		
		public int traverse(treenode c,int target)
		{
			if(first==true)
			{
				first = false;
				System.out.println(c.value);
			}
			
			for(int i=0;i<c.child.size();i++)
			{
				treenode n = c.child.get(i);
				for(int j=0;j<Level;j++)
				{
					System.out.print("--");
				}
				System.out.print(">");
				
				System.out.println(n.value+":"+n.time);
				
				if(target==n.value)
				{
					t++;
				}
				
				Level++;
				
				traverse(n, target);
				
				Level--;
			}
			return t;
		}
	}
}
