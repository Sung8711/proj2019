package proj2019;

public class midtest4 
{
	static class Node
	{
		int data;Node link;
		Node()
		{
			data=0;link=null;
		}
		Node(int a)
		{
			data=a;link=null;
		}
		int getdata()
		{
			return data;
		}
		Node getnext()
		{
			return link;
		}
		void setdata(int a)
		{
			data=a;
		}
		void setnext(Node n)
		{
			link=n;
		}
	}
	static class Link
	{
		int count=0;
		int time=-1;
		Node head;
		Link()
		{
			head=null;
		}
		void add(int a)
		{
			Node tmp=new Node(a);
			Node tmp2,tmp3;
			count++;
			if(head==null)
			{
				head=tmp;
			}
			else
			{
				tmp3=head;
				do
				{
					tmp2=tmp3;
					tmp3=tmp2.link;
				}while(tmp3!=null);
				tmp2.link=tmp;
			}
		}
		//========================Error=====================
		int length()
		{
//			count=0;              /*
//			Node tmp=head;
//			while(tmp!=null)            冗碼
//			{
//				count++;
//				tmp=tmp.getnext();     */
//			}
			return count;
		}
		//==================================================
		void print()
		{
			Node tmp=head;
			System.out.print("{");
			while(tmp!=null)
			{
				System.out.print(tmp.data+" ");
				tmp=tmp.link;
			}
			System.out.println("}");
		}
		int get(int index)
		{
			Node tmp=head;
			int zz=0;
			int time1=-1;
			while(time1!=index)
			{
				zz=tmp.getdata();
				tmp=tmp.getnext();
				time1++;
			}
			time=-1;
			return zz;
		}
	}
	public static void show(Link l)
	{
//		Node tmp=l.head;   /*
//		System.out.print("{");
//		while(tmp!=null)            方法一
//		{
//			System.out.print(tmp.data+" ");
//			tmp=tmp.link;
//		}
//		System.out.println("}");     */
//==============方法二==================
		for(int i=0;i<l.length();i++)
		{
			System.out.print(l.get(i)+" ");
		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Link test = new Link();
		test.add(33);test.add(80);test.add(70);test.add(25);test.add(28);
		test.add(90);test.add(34);test.add(22);test.add(31);test.add(9);
		show(test);
	}
}
