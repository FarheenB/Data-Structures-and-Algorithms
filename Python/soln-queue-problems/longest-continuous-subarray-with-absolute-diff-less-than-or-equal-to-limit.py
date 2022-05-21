#https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        left = 0
        right = 1
        cur_max = deque([0])
        cur_min = deque([0])
        max_count = 1
        while left <= right and right < len(nums):
            cur = nums[right]
            
            if cur < nums[cur_min[-1]]:
                while cur_min and nums[cur_min[-1]] > cur:
                    cur_min.pop()
                
            elif cur > nums[cur_max[-1]]:
                while cur_max and nums[cur_max[-1]] < cur:
                    cur_max.pop()
                    
            cur_max.append(right)
            cur_min.append(right)
            
            while nums[cur_max[0]] - nums[cur_min[0]] > limit:
                left += 1
                if left > cur_min[0]:
                    cur_min.popleft()
                if left > cur_max[0]:
                    cur_max.popleft()
            
            max_count = max(max_count, right - left + 1)
            right += 1
        return max_count