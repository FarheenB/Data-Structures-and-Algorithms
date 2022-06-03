class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        
        def dfs(nums, k, index, path, res):
            #if k < 0:  #backtracking
                #return 
            if k == 0:
                res.append(path)
                return # backtracking 
            for i in range(index, len(nums)):
                dfs(nums, k-1, i+1, path+[nums[i]], res)
                
        dfs(range(1,n+1), k, 0, [], res)
        return res

