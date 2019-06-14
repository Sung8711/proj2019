package proj2019;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Lab33 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		tree x = new tree(0);
		treenode r = x.root;
		for(int i=0;i<5;i++)
		{
			Random ran = new Random();
			int num = ran.nextInt(1000);
			treenode n = new treenode(num);
			if(i==0)
			{
				r.child.add(n);
			}
			else
			{
				int aa=r.child.size();
				for(int j=0;j<aa;j++)
				{
					if(num <= r.child.get(j).value)
					{						
						r.child.add(j, n);
						break;
					}
					if(j==aa-1)
					{
						r.child.add(n);
						break;
					}
				}
			}
		}
		x.traverse(r);
	}
	public static class treenode
	{
		int value;
		ArrayList<treenode> child;
		treenode(int v)
		{
			value = v;
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
		
		public void traverse(treenode c)
		{
			System.out.print(c.value+" ");
			for(int i=0;i<c.child.size();i++)
			{
				treenode n = c.child.get(i);
				
//				System.out.print(n.value+" ");
				
				traverse(n);
			}
		}
	}
}
