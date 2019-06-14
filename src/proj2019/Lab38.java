package proj2019;

import java.io.*;
import java.util.*;

public class Lab38 
{
	public static String fp = "C:\\Users\\MMLAB\\Desktop\\fptree.txt";
	public static void main(String[] args) throws IOException
	{
		Scanner scn = new Scanner(System.in);
		// TODO Auto-generated method stub
		tree x = new tree('0');
		//treenode t = x.root;
		HTcreate(x.headerTable,fp);
		System.out.println("所有元素及次數：");
		for(int i=0;i<x.headerTable.size();i++)
		{
			System.out.print(x.headerTable.get(i).value+":"+x.headerTable.get(i).time+" ");
		}
		System.out.println("");
		System.out.println("輸入min_sup：");
		int t = scn.nextInt();
		HTfilter(x.headerTable,t);
		scn.close();
		System.out.println("篩選扣除小於min_sup次數後：");
		for(int i=0;i<x.headerTable.size();i++)
		{
			System.out.print(x.headerTable.get(i).value+":"+x.headerTable.get(i).time+" ");
		}
		System.out.println("");
		System.out.println("經過header table篩選後的資料：");
		fptree(x,fp);
		System.out.println("樹：");
		x.traverse();
	}
	public static void fptree(tree a,String s) throws IOException
	{
		treenode node = a.root;
		ArrayList<ArrayList<Character>> test = new ArrayList<ArrayList<Character>>();
		FileReader fr = new FileReader(s);
		BufferedReader bfr = new BufferedReader(fr);
		String record;
		while((record=bfr.readLine())!=null)
		{
			ArrayList<Character> item = new  ArrayList<Character>();
			char[] data = record.toCharArray();
			for(int i=0 ; i<a.headerTable.size() ; i++) 
			{
				for(int j=0 ; j<data.length ;j++) 
				{
					if(a.headerTable.get(i).value == data[j])
					{
						item.add(data[j]);
					}
				}
			}
			test.add(item);
		}
		char[][] im2 = new char[test.size()][test.get(0).size()];
		for(int i=0;i<test.size();i++)
		{
			for(int j=0;j<test.get(i).size();j++)
			{
				im2[i][j] = test.get(i).get(j);
				System.out.print(im2[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		for(int i=0;i<im2.length;i++)
		{
			for(int j=0;j<im2[i].length;j++)
			{
				node=addNode(node,im2[i][j],a);
			}
		}
		bfr.close();
		fr.close();
	}
	public static treenode addNode(treenode a,char b,tree c)
	{
		if(a.child.isEmpty()) 
		{
			treenode newnode = new treenode(b);
			a.child.add(newnode);
			addHT(c.headerTable,newnode);
			return a.child.get(0);
		}
		for(int i=0 ; i<a.child.size() ; i++)
		{
			
			if(a.child.get(i).value == b)
			{
				
				a.child.get(i).time++;
				return a.child.get(i);
			}
			if(i==a.child.size()-1)
			{
				treenode newnode = new treenode(b);
				a.child.add(newnode);
				addHT(c.headerTable,newnode);
				return a.child.get(i+1);
			}
		}
		return null;
	}
	public static void HTcreate(ArrayList<treenode> headerTable,String s) throws IOException
	{
		FileReader fr = new FileReader(s);
		BufferedReader bfr = new BufferedReader(fr);
		String record;
		while((record=bfr.readLine())!=null)
		{
			char[] data = record.toCharArray();
			for(int i=0;i<data.length;i++)
			{
				if(headerTable.isEmpty()) 
				{
					headerTable.add(new treenode(data[i]));
					continue;
				}
				for(int j=0 ; j<headerTable.size() ; j++) 
				{
					
					if(headerTable.get(j).value == data[i]) 
					{
						headerTable.get(j).time++;
						break;
					}
					if(j==headerTable.size()-1) 
					{
						headerTable.add(new treenode(data[i]));
						break;
					}
				}
			}
		}
		bfr.close();
		fr.close();
	}
	public static void HTfilter(ArrayList<treenode> ht , int times) 
	{
		ArrayList<treenode> tmp = new ArrayList<treenode>();
		for(int i=0 ; i<ht.size() ; i++) 
		{
			if(ht.get(i).time >= times)
			{
				tmp.add(ht.get(i));
			}
		}
		tmp=insertSort(tmp);
		int headerTableSize = ht.size();
		for(int i=0 ; i<headerTableSize ; i++) 
		{
			ht.remove(0);
		}
		for(int i=0 ; i<tmp.size() ; i++) 
		{
			ht.add(tmp.get(i));
		}
	}
	public static ArrayList<treenode> insertSort(ArrayList<treenode> b) 
	{
		ArrayList <treenode> a = new ArrayList<treenode>();
		for(int i=0 ; i<b.size() ; i++) 
		{
			int insert = b.get(i).time;
			if(i==0) 
			{
				a.add(b.get(i));
				continue;
			}
			for(int j=0 ; j<a.size() ; j++) 
			{
				if(insert > a.get(j).time)
				{
					a.add(j,b.get(i));
					break;
				}
				if(j==a.size()-1)
				{
					a.add(b.get(i));
					break;
				}
			}
		}
		return a;
	}
	public static class treenode
	{
		char value;
		int time;
		ArrayList<treenode> child;
		treenode(char v)
		{
			value = v;
			time = 1;
			child = new ArrayList<treenode>();
		}
	}
	public static class tree 
	{
		ArrayList<treenode> headerTable = new ArrayList<treenode>();
		treenode root;
		tree(char v)
		{
			root = new treenode(v);
		}
		int Level = 2; 
		boolean first = true;
		public void traverse(treenode c) 
		{
			if(first) 
			{
				first=!first;
				System.out.println(c.value);
			}
			for(int i=0; i<c.child.size(); i++)
			{
				treenode n = c.child.get(i);
				for(int j=0 ; j<(Level-1) ; j++) 
				{
					System.out.print("--");
				}
				System.out.print(">");
				System.out.println(n.value);
				Level++;
				traverse(n);
				Level--;
			}
		}
		public void traverse()
		{
			traverse(root);
		}
	}
	public static void addHT(ArrayList<treenode> HT,treenode a) 
	{
		for(int i=0 ; i<HT.size() ; i++) 
		{
			if(a.value == HT.get(i).value) 
			{
				HT.get(i).child.add(a);
			}
		}
	}
}
