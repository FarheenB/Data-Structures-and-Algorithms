# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    max_sum=-1000
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0;
        
        def dfs(root):
            if root is None:
                return 0
            
            left=dfs(root.left)
            right=dfs(root.right)
            
            straightPath=max(max(left,right)+root.val,root.val)
            summ=left+root.val+right
            rootPath=max(summ,root.val)
            self.max_sum=max(self.max_sum,straightPath,rootPath)
            
            return straightPath
            
        dfs(root)
        return self.max_sum
