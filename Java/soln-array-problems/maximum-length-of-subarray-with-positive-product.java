/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/length-of-longest-subarray-with-positive-product/
 https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
*/

class Solution {
    public int getMaxLen(int[] nums) {
        int count_pos=0;
        int count_neg=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
           if(num == 0)  {
                count_pos = 0;
                count_neg = 0;
            }
            else if(num > 0) {
                count_pos++;
                count_neg = count_neg == 0 ? 0  : count_neg+1;
            }
            else {
                int temp = count_pos;
                count_pos = count_neg == 0 ? 0  : count_neg+1;
                count_neg = temp+1;
            }
            max = Math.max(max, count_pos);
        }
        return max;
    }
}