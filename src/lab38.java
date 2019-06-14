import java.util.ArrayList;

public class lab38 
{

	public static void main(String[] args) 
	{
		char[] a = {'f','a','c','d','g','i','m','p'};
		char[] b = {'a','b','c','f','l','m','o'};
		char[] c = {'b','f','h','j','o','w'};
		char[] d = {'b','c','k','s','p'};
		char[] e = {'a','f','c','e','l','p','m','n'};
		tree x = new tree('0');
		
		HTCreat(x.headerTable,a);
		HTCreat(x.headerTable,b);
		HTCreat(x.headerTable,c);
		HTCreat(x.headerTable,d);
		HTCreat(x.headerTable,e);
		
		System.out.println("所有元素：");
		for(int i=0;i<x.headerTable.size();i++)
		{
			System.out.print(x.headerTable.get(i).value+":"+x.headerTable.get(i).times+" ");
		}
		System.out.println("");
		System.out.println("篩選後的header table跟次數：");
		
		HTFilter(x.headerTable,3);
		
		for(int i=0;i<x.headerTable.size();i++)
		{
			System.out.print(x.headerTable.get(i).value+":"+x.headerTable.get(i).times+" ");
		}
		System.out.println("");
		System.out.println("經過header table篩選後的資料：");
		
		FPtree(x,a);
		FPtree(x,b);
		FPtree(x,c);
		FPtree(x,d);
		FPtree(x,e);
		
		System.out.println("樹：");
		x.traverse();
		/*
		System.out.println("\n撅內銝�銝eader table蝣箏祕���邦��蝯��");
		System.out.println(x.root.child.get(0).child.get(1));
		System.out.println(x.headerTable.get(5).child.get(1));*/
	}
	
	public static class treenode
	{
		char value;
		int times;
		ArrayList<treenode> child;
		
		treenode(char v)
		{
			value = v;
			times = 1;
			child = new ArrayList<treenode>();
		}
	}
	public static class tree
	{
		static int count=2 ;
		static boolean first=true;
		ArrayList<treenode> headerTable = new ArrayList<treenode>();
		treenode root;
		tree(char v)
		{
			root = new treenode(v);
		}
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
				for(int j=0 ; j<(count-1) ; j++) 
				{
					System.out.print("--");
				}
				System.out.print(">");
				System.out.println(n.value);
				count++;
				traverse(n);
				count--;
			}
		}
		public void traverse()
		{
			traverse(root);
		}
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
				
				a.child.get(i).times++;
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
	
	public static void FPtree(tree a,char[] b)
	{
		treenode node = a.root;
		ArrayList<Character> item = new  ArrayList<Character>();
		for(int i=0 ; i<a.headerTable.size() ; i++) 
		{
			for(int j=0 ; j<b.length ;j++) 
			{
				if(a.headerTable.get(i).value == b[j])
					item.add(b[j]);
			}
		}
		char[] item2 = new char[item.size()];
		for(int i=0 ; i<item2.length ; i++) 
		{
			item2[i] = item.get(i);
			System.out.print(item2[i]+" ");
		}
		System.out.println();
		for(int i=0 ; i<item2.length ; i++) 
		{
			node=addNode(node,item2[i],a);
		}
	}
	
	public static void HTCreat(ArrayList<treenode> headerTable , char[] data)
	{
		for(int i=0 ; i<data.length ;i++) 
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
					headerTable.get(j).times++;
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
	
	public static void HTFilter(ArrayList<treenode> headerTable , int frequency) 
	{
		ArrayList<treenode> temp = new ArrayList<treenode>();
		for(int i=0 ; i<headerTable.size() ; i++) 
		{
			if(headerTable.get(i).times >= frequency)
				temp.add(headerTable.get(i));
		}
		
		temp=insertSort(temp);
	
		int headerTableSize = headerTable.size();
		for(int i=0 ; i<headerTableSize ; i++) 
		{
			headerTable.remove(0);
		}
		for(int i=0 ; i<temp.size() ; i++) 
		{
			headerTable.add(temp.get(i));
		}
	}
	
	public static ArrayList<treenode> insertSort(ArrayList<treenode> b) 
	{
		ArrayList <treenode> a = new ArrayList<treenode>();
		for(int i=0 ; i<b.size() ; i++) 
		{
			int insert = b.get(i).times;
			
			if(i==0) 
			{
				a.add(b.get(i));
				continue;
			}
			
			for(int j=0 ; j<a.size() ; j++) 
			{
				
				if(insert > a.get(j).times)
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
