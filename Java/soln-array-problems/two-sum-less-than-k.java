/**
 @author Farheen Bano

 Date 09-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-less-than-k
*/

/**
 Solution 1: Nested Loops 
 Time Complexity: O(n^2)
*/

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max=-1;
        if(nums.length<2)
            return max;     
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum<k){
                    max=Math.max(max,sum);
                }
                
            }
        }
        return max;
    }
}

/** 
   Solution 1: Sorting Arrays
   Time Complexity: O(nlogn)
*/

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max=-1;
        if(nums.length<2)
            return max;     
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left>=0 && right<nums.length && left<right){
            int sum=nums[left]+nums[right];
            if(sum<k){
                left++;
                max=Math.max(max,sum);
            }
            else if(sum>=k)
                right--; 
        }
        return max;
    }
}

