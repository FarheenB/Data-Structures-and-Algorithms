class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums = sorted(nums)
        path = []
        
        def dfs(nums):
            if not nums:
                res.append(path.copy())
                return
            
            for i in range(len(nums)):
                if i>0 and nums[i]==nums[i-1]:
                    continue
                path.append(nums[i])
                dfs(nums[:i]+nums[i+1:])
                path.pop() 
    
                    
        dfs(nums)
        return res