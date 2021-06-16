/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int[] result=new int[2];
    public int[] searchRange(int[] nums, int target) {
        binarySearchFirst(nums,0,nums.length-1,target);
        binarySearchLast(nums,0,nums.length-1,target);
        return result;
    }
    
    public void binarySearchFirst(int[] nums,int start, int end, int target){
        int pos=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                pos=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }                
        }
        result[0]=pos;
    }
    
    public void binarySearchLast(int[] nums,int start, int end, int target){
        int pos=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                pos=mid;
                start=mid+1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }                
        }
        result[1]=pos;
    }
}
