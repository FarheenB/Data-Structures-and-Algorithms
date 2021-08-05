/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2)
            return new int[2];
        int left=0;
        int right=nums.length-1;
        while(left>=0 && right<nums.length && left<right){
            int sum=nums[left]+nums[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else{
                int result[]={left+1,right+1};
                return result;
            }                
        }
        return new int[2];      
    }
}