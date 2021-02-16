/*
https://leetcode.com/problems/split-array-largest-sum/
*/

class Solution {
    public int splitArray(int[] nums, int m) {
       if(nums.length<m)
            return -1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        int start=max;
        int end=sum;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(nums,nums.length,m,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] nums, int n, int m, int mid_max){
        int subarray=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum+nums[i]>mid_max){
                subarray++;
                sum=0;
            }
            if(subarray>m)
                return false;
            sum+=nums[i];    
        }
        return true;
    }
}