
# https://leetcode.com/problems/sort-an-array

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        newArray = []
        heapq.heapify(nums)
        while(nums):
            newArray.append(heapq.heappop(nums))
        return newArraya