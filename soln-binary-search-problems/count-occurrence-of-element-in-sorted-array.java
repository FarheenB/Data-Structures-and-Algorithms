/*
https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int[] result=new int[2];
    int count(int[] nums, int n, int target) {
        binarySearchFirst(nums,0,n-1,target);
        binarySearchLast(nums,0,n-1,target);
        return result[1]>=0?result[1]-result[0]+1:0;
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