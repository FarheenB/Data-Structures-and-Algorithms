'''
 @author Farheen Bano
 
 Date 08-05-2022

 Reference-
 https://practice.geeksforgeeks.org/problems/bubble-sort/1
'''

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        for i in range(0,len(nums)-1):
            swapped=False
            
            for j in range(0, len(nums)-i-1):
                if nums[j]>nums[j+1]:   
                    temp=nums[j]
                    nums[j]=nums[j+1]
                    nums[j+1]=temp
                    swapped=True
                
            if not(swapped):
                break
            
        return nums