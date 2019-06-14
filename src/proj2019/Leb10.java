package proj2019;

public class Leb10 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int []lab10={5,2,3,6,2,10,15,8,20,4};
		int max=0;
		int []b=new int[findmax(max,lab10)+1];
		show(lab10);
//		System.out.println(" ");
		show(b);
//		System.out.println(" ");
		BucketSort(lab10,b);
		System.out.println("------After BucketSort------");
		show(lab10);
		show(b);
	}
	
	public static int findmax(int a,int b[])
	{
		for(int i=0;i<b.length;i++)
		{
			if(b[i]>a)
			{
				a=b[i];
			}
		}
		return a;
	}
	
	public static void BucketSort(int a[],int b[])
	{
		for(int i=0;i<a.length;i++)
		{
			b[a[i]]++;
		}
		int ax=0;
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[i];j++)
			{
				a[ax++]=i;
			}
		}
	}
	
	public static void show(int a[])
	{
		System.out.print("[ ");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("]");
	}

}
