package proj2019;

public class Leb13 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[]= {1,3,5,14,16,25};
		int b[]= {2,4,11,12,26,27};
		int c[]=new int[a.length+b.length];
		Merge(a,b,c);
		for(int i:c)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void Merge(int a[], int b[],int c[])
	{
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<=b[j])
			{
				c[k]=a[i];
				k++;
				i++;
			}
			else
			{
				c[k]=b[j];
				k++;
				j++;
			}
		}
		while(i<a.length)
		{
			c[k]=a[i];
			k++;
			i++;
		}
		while(j<b.length)
		{
			c[k]=b[j];
			k++;
			j++;
		}
	}
}
