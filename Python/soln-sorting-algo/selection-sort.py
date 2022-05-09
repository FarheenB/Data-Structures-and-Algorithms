'''
 @author Farheen Bano
 
 Date 08-05-2022

 Reference-
 https://practice.geeksforgeeks.org/problems/selection-sort/1
'''

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        for i in range(0,len(nums)-1):
            min_index=i
            for j in range(i+1, len(nums)):
                if nums[j]<nums[min_index]:
                    min_index=j
            temp=nums[i]
            nums[i]=nums[min_index]
            nums[min_index]=temp
            
        return nums