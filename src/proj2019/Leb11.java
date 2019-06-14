package proj2019;

public class Leb11 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int lab11[]= {1,11,111,54,23,542,698,78,452,1235};
		RadixSort(lab11,findMax(lab11));
		for(int i:lab11)
		{
			System.out.print(i+" ");
		}
	}
	public static int findMax(int a[])
	{
		int max,count=0,aa=0;
		for(int i=0;i<a.length;i++)
		{
			count=0;
			max=a[i];
			while(max!=0)
			{
				max=max/10;
				count++;
			}
			if(aa<count)
			{
				aa=count;
			}
		}
		return aa;
	}
	
	public static void RadixSort(int a[],int d)
	{
		int x=1;
		for(int i=0;i<d-1;i++)
		{
			x=x*10;
		}
		int k = 0;
        int n = 1;
        int[][] tmp = new int[a.length][a.length];
        int[] b = new int[a.length];
        while(n<=x) 
        { 
            for(int num:a) 
            { 
                int lsd=(num/n) % 10; 
                tmp[lsd][b[lsd]]=num; 
                b[lsd]++; 
            } 
            for(int i=0;i<a.length;i++) 
            { 
                if(b[i] != 0)
                {
                    for(int j=0;j<b[i];j++) 
                    { 
                        a[k]=tmp[i][j];  
                        k++; 
                    } 
                }
                b[i] = 0; 
            } 
            n=n*10; 
            k=0; 
        } 
	}

}
