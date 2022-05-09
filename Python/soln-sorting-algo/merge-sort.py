'''
 @author Farheen Bano
 
 Date 08-05-2022

 Reference-
 https://practice.geeksforgeeks.org/problems/merge-sort/1
'''

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        def merge_sort(nums: List[int]):
            if len(nums) == 1: 
                return
            mid = len(nums)//2
            L = nums[:mid]
            R = nums[mid:]
            
            merge_sort(L)
            merge_sort(R)
            merge(nums,L,R)

        def merge(nums: List[int],L: List[int],R: List[int]):
            i, j, k = 0, 0, 0
            while i<len(L) and j<len(R):
                if L[i]<R[j]:
                    nums[k] = L[i]
                    i+=1
                else:
                    nums[k] = R[j]
                    j+=1
                k+=1
            nums[k:] = L[i:] if i<len(L) else R[j:]
                
        merge_sort(nums)
        return nums