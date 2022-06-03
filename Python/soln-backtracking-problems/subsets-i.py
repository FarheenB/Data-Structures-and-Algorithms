class Solution:
    def subsets(self, nums):
        res = []
        def dfs(nums, index, path, res):
            res.append(path)
            # print("Start")

            for i in range(index, len(nums)):
                # print(i)
                dfs(nums, i+1, path+[nums[i]], res)
                
        dfs(nums, 0, [], res)
        return res

