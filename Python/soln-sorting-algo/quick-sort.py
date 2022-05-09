'''
 @author Farheen Bano
  
 Date 08-05-2022
  
 Reference-
 https://practice.geeksforgeeks.org/problems/quick-sort/1
'''

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def quick_sort(nums, start, end):
            if start<end:
                pIndex=partition(nums,start,end)
                quick_sort(nums,start, pIndex-1)
                quick_sort(nums, pIndex+1, end)

        def partition(nums, start, end):
            pivot=nums[end]
            pIndex=start
            for i in range(start,end):
                if nums[i]<=pivot:
                    temp=nums[i]
                    nums[i]=nums[pIndex]
                    nums[pIndex]=temp
                    pIndex+=1

            temp=nums[end]
            nums[end]=nums[pIndex]
            nums[pIndex]=temp

            return pIndex

        quick_sort(nums,0,len(nums)-1)
        return nums
        