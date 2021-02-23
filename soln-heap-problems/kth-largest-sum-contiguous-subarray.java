/*
https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.*;
public class solution {

	public static int kthLargestSum(int arr[], int n, int k) {        
  		int sum[] = new int[n + 1];
        sum[0] = 0;
        sum[1] = arr[0];

        //calculate prefix sum array
        for (int i = 2; i <= n; i++)
            sum[i] = sum[i-1] + arr[i-1];
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
      	for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
           		int s=sum[j]-sum[i-1];
            	minHeap.add(s);
                if(minHeap.size()>k){
                    minHeap.poll();
                }
            }
        }         
        return minHeap.peek();
	}
}
