'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-greater-element-i/
'''

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        for i in range(len(nums1)):
            pass_num = False
            num = -1
            for j in range(len(nums2)):
                if nums2[j] == nums1[i]:
                    pass_num = True
                if nums2[j] > nums1[i] and pass_num:
                    num = nums2[j]
                    break
            result.append(num)            
        return result  