package proj2019;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Lab32 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		tree x = new tree(0);
		
		treenode r = x.root;
		
//		treenode c = r;
//		for(int i =1;i<=4;i++)
//		{
//			for(int j=0;j<=8;j=j+4)
//			{
//				treenode n = new treenode(i+j);
//				if(j==0)
//				{
//					r.child.add(n);
//					c = n;
//				}
//				else
//				{
//					c.child.add(n);
//					c = n;
//				}
//			}
//		}
		treenode c1 = r;
		treenode c2 = r;
		treenode c3 = r;
		treenode c4 = r;
		for(int i=1;i<13;i++)
		{
			treenode n = new treenode(i);
			if(i%4==1)
			{
				c1.child.add(n);
				c1 = n;
			}
			if(i%4==2)
			{
				c2.child.add(n);
				c2 = n;
			}
			if(i%4==3)
			{
				c3.child.add(n);
				c3 = n;
			}
			if(i%4==0)
			{
				c4.child.add(n);
				c4 = n;
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
