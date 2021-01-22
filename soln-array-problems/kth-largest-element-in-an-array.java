/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    int[] nums;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums=nums;
        return quick_select(0,this.nums.length-1,nums.length-k);
    }
    
    public int quick_select(int left, int right, int kth_smallest){  
        if(left==right){
            return nums[left]; 
        }
        
        int pivot_index=partition(left,right);
        if(pivot_index==kth_smallest)
            return nums[pivot_index];
        
        else if(kth_smallest<pivot_index)
            return quick_select(left,pivot_index-1,kth_smallest);
        else
            return quick_select(pivot_index+1,right,kth_smallest);
    }
    
    public int partition(int left, int right){
        int pivot_index=right;
        int i=left;
        int j=left;
        
        while(j<=right){
            if(nums[j]<nums[pivot_index]){
                swap(i,j);
                i++;
            }
            j++;
        }
        swap(i,pivot_index);
        return i;
    }
    
    public void swap(int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}