/*
https://leetcode.com/problems/minimum-size-subarray-sum/
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=s){
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++; 
        }
        return min!=Integer.MAX_VALUE?min:0;
    }
}