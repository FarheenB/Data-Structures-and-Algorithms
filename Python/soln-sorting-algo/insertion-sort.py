'''
 @author Farheen Bano
 
 Date 08-05-2022

 Reference-
 https://practice.geeksforgeeks.org/problems/insertion-sort/1
'''

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        for i in range(1,len(nums)):
            curr=nums[i]
            j=i-1
            while j>=0 and nums[j]>curr:
                nums[j+1]=nums[j]
                j=j-1
            nums[j+1]=curr
            
        return nums