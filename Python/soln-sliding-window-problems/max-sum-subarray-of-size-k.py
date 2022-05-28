
# https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

class Solution:
    def maximumSumSubarray (self,K,nums,N):
        i,j=0,0
        sum=0
        max_sum=0
        
        while(j<len(nums)):
            sum+=nums[j]
            
            if j-i+1==K:
                max_sum=max(max_sum,sum)
                sum-=nums[i]
            
                i+=1
            
            j+=1
        return max_sum