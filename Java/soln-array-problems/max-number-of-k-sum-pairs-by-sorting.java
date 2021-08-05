/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/max-number-of-k-sum-pairs
 Using Sorting
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        if(nums.length<2)
            return 0;
        Arrays.sort(nums);
        int count=0;
        int left=0;
        int right=nums.length-1;
        while(left>=0 && right<nums.length && left<right){
            int sum=nums[left]+nums[right];
            if(sum<k)
                left++;
            else if(sum>k)
                right--;
            else{
                count++;
                left++;
                right--;
            }
        }
        return count;      
    }
}