class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        def dfs(nums, index, path, res):
            res.append(path)
            for i in range(index, len(nums)):
                if i > index and nums[i] == nums[i-1]:
                    continue
                dfs(nums, i+1, path+[nums[i]], res)
                
        dfs(nums, 0, [], res)
        return res

