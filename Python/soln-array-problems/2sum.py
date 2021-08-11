"""
 @author Farheen Bano

 Date 11-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum/
"""

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)<2:
            return []
        record=dict()
        for i in range(len(nums)):
            other=target-nums[i]
            if nums[i] in record:
                return [record[nums[i]],i]
            record[other]=i
        return []
        