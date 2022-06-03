class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        def dfs(nums, path, res):
            if not nums:
                res.append(path)
                return # backtracking
            for i in range(len(nums)):
                dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)

        dfs(nums, [], res)
        return res

 