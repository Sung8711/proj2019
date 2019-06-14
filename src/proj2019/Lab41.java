package proj2019;

import java.util.*;

public class Lab41 
{
	
	public static void main(String[] args) 
	{
		String A = "ASDFGHJ";
		System.out.println(A);
		char[] B = A.toCharArray();
		System.out.println(B[6]);
		for(int i=0 ; i<B.length-1 ; i++) {
			B[i] = B[i+1];
		}
		A = new String(B);
		A = A.substring(0,6);
		System.out.println(A);
		// TODO Auto-generated method stub
		
	}
	
}
class Itemset
{
	ArrayList itemset = new ArrayList();
	ArrayList tidset = new ArrayList();
	int sc ;
	
}