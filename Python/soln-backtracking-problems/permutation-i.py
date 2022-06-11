class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res=[]
        n=len(nums)
        path=[]
        def dfs(nums):
            if len(path)==n:
                res.append(path.copy())
                return
            
            for i in range(len(nums)):
                path.append(nums[i])
                dfs(nums[:i]+nums[i+1:])
                path.pop()
                
        dfs(nums)
        return res