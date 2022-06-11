class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res=[]
        
        subset=[]
        def dfs(i):
            if i>=len(nums):
                res.append(subset.copy())
                return 
            
            #  decision to include the element at nums[i]
            subset.append(nums[i])
            dfs(i+1)

            #  decision NOT to include the element at nums[i]
            subset.pop()
            while i+1<len(nums) and nums[i]==nums[i+1]:
                i+=1
            dfs(i+1)
        
        dfs(0)
        return res
