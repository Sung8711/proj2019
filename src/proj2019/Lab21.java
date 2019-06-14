package proj2019;
import java.util.*;
public class Lab21 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub 
   		ArrayList<Integer> x = new ArrayList<Integer>();
   		x.add(18);x.add(2);x.add(20);x.add(34);x.add(12);
   		int listsize = x.size();	
   		for(int i=0; i<listsize-1; i++)
   		{
   			System.out.println("#"+(i+1)+" pass:");
   			
   			for(int j=0; j<(listsize-i-1); j++)
   			{	
   				System.out.print(" #"+(j+1)+" compare:");
   				
   				if(x.get(j) > x.get(j+1))
   				{
   					swap(x, j, j+1);	
   				}
   				show(x);
   			}
   		}
   }
   
   
   public static void swap(ArrayList<Integer> a, int x, int y)
	{
		int temp;
		temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
	}
 
 	public static void show(ArrayList<Integer> a)
 	{
 		for(int i=0; i<a.size(); i++)
 		{	
 			System.out.print(a.get(i)+" ");
 		}
 		System.out.println();
 	}

}
