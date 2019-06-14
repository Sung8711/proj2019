package proj2019;

public class Leb12 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int lab12[]= {1,11,111,54,23,542,698,78,452,135};
		int bbb[]=new int[lab12.length];
		QuickSort(lab12,bbb);
		System.out.println(" ");
		for(int i=0;i<bbb.length;i++)
		{
			System.out.print(bbb[i]+" ");
		}
	}
	public static void QuickSort(int a[],int bbb[])
	{
		boolean stop=false;
		int num=a[0];
		int i=0,j=a.length-1;
		int tmp;
		if(a.length==1 )
		{
			for(int na=0;na<bbb.length;na++)
			{
				if(bbb[na]==0)
				{
					bbb[na]=a[0];
					break;
				}
			}
			stop=true;
		}
		while(stop!=true)
		{
			for(i=0;i<a.length;i++)
			{
				if(a[i]>num)
				{
					break;
				}
			}
			for(j=a.length-1;j>0;j--)
			{
				if(a[j]<num)
				{
					break;
				}
			}
			if(i>=j)
			{
				tmp=a[0];
				a[0]=a[j];
				a[j]=tmp;
				stop=true;
				int b[]=new int[j+1];
				for(i=0;i<b.length;i++)
				{
					b[i]=a[i];
				}
				QuickSort(b,bbb);
				if(j!=a.length-1)
				{
					int c[]=new int[a.length-j-1];
					for(i=0;i<c.length;i++)
					{
						c[i]=a[i+j+1];
					}
					QuickSort(c,bbb);
				}
				
			}
			else 
			{
				tmp=a[i];
				a[i]=a[j];
				a[j]=tmp;
			}
		}
	}

}
