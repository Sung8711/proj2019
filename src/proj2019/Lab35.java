package proj2019;

import java.util.*;
import java.io.*;

public class Lab35 
{
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
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
		x.traverse(t);
		fr.close();
		bfr.close();
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
	public static class tree //建樹
	{
		treenode root;
		tree(int v)
		{
			root = new treenode(v);
		}
		int Level = 1; //階層 先設一
		public void traverse(treenode c) //深度優先走訪
		{
			System.out.print("---"+"Level:"+Level+"---"+"\t"+c.value+"\n"); //先印出階層 因為第一階是根 所以先印出根的階層數
			//Level++;
			for(int i=0;i<c.child.size();i++)
			{
				treenode n = c.child.get(i); //往子節點走訪
				
//				System.out.print(n.value+":"+n.time+" ");
				
				Level++; //階層數+1
				
				traverse(n);  //遞迴
				
				Level--; //由於前面加過了為了防止重複一直加下去所以要扣回來
			}
		}
	}
}
