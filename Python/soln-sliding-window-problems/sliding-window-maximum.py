class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        from collections import deque
        q = deque() 
        res = []
        j = 0 ; i = 0
        while j<len(nums):
            while q and nums[j]>q[-1]:
                q.pop()
            q.append(nums[j])
            if j-i+1<k:
                j+=1
            elif j-i+1==k:
                res.append(q[0])
                if q[0]==nums[i]:
                    q.popleft()
                i+=1
                j+=1
        return res