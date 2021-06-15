/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/target-sum/

 NOTE: Variation of 0/1 Knapsack and count subset sum with given difference
*/

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        S=Math.abs(S);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        // Invalid S return 0
        if( S > sum || (sum + S) % 2 != 0 )
            return 0;
        
        int target_sum=(S+sum)/2;
        return countSubsetSum(nums,target_sum);
    }
    
    public static int countSubsetSum(int[] nums, int sum)
    {
        int[] dp=new int[sum+1];
        
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dp.length - 1];
    }
}
