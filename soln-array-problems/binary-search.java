/*
https://www.geeksforgeeks.org/binary-search/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1;i<=T;i++){
		    int N=sc.nextInt();
		    int K=sc.nextInt();
		    int arr[]=new int[N];
		    for(int a=0;a<N;a++)
		        arr[a]=sc.nextInt();
		    System.out.println(BinarySearch(arr,0,arr.length-1,K));
		}
	}
	public static int BinarySearch(int arr[], int start, int end, int x) 
    { 
        if (start<=end) { 
            int mid = start + (end - start) / 2; 
            if (arr[mid] == x) 
                return 1; 
            if (arr[mid] > x) 
                return BinarySearch(arr, start, mid - 1, x); 
            return BinarySearch(arr, mid + 1, end, x); 
        } 
        return -1; 
    } 
}