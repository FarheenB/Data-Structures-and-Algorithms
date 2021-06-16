/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static List<Integer> heapSort(int[] arr, int n, int k){
	    PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
	    
	    ArrayList<Integer> result=new ArrayList<>();
	    
	    int i=0;
	    while(i<arr.length){
	        minHeap.add(arr[i]);
	        if(minHeap.size()>=k){
	            result.add(minHeap.remove());
	        }
	        i++;
	    }
	    
	    while(!minHeap.isEmpty()){
	        result.add(minHeap.remove());
	    }
	    return result;
	}

	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1;i<=T;i++){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int[] arr=new int[n];
		    for(int j=0;j<n;j++)
		        arr[j]=sc.nextInt();
	        for(int num:heapSort(arr,n,k))
		        System.out.print(num+" ");
		    System.out.println();		    
		}
	}
}
