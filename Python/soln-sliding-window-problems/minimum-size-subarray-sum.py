class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        windowSum, windowStart = 0,0
        minLength = math.inf
        for windowEnd in range(len(nums)):
            windowSum+=nums[windowEnd]
            while windowSum >= s:
                minLength = min(minLength, windowEnd - windowStart + 1)
                windowSum -= nums[windowStart]
                windowStart+=1
        if minLength == math.inf:
            return 0
        return minLength