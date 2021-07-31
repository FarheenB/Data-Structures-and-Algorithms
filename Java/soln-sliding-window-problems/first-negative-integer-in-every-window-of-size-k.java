/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0
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
		    int nums[]=new int[N];
		    for(int j=0;j<N;j++){
		        nums[j]=sc.nextInt();
		    }
		    int k=sc.nextInt();
		
    		int result[]=firstNegativeInWindow(nums,k);
    		for(int a=0;a<result.length;a++){
    		    System.out.print(result[a]+" ");
    		}
    		System.out.println();
		}
	}

    public static int[] firstNegativeInWindow(int[] nums, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Integer> neg_queue=new LinkedList<>();
        
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]<0)
                neg_queue.offer(nums[j]);                   
            
            if((j-i+1)==k){
                int neg;
                if(neg_queue.isEmpty())
                    neg=0;
                else
                    neg=neg_queue.peek();
                result.add(neg);
                if(neg==nums[i]){
                    neg_queue.poll();
                }
                i++;               
            }
            j++;
        }
        
        int[] neg_arr=new int[result.size()];
        for(i=0;i<result.size();i++){
            neg_arr[i]=result.get(i);
        }
        return neg_arr;
    }
}
