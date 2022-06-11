# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum_no=0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        
        def dfs(root, number):
            if root is None:
                return
            
            digit=root.val
            number=number*10+digit
            
            if root.left is None and root.right is None:
                self.sum_no+=number
                return
            
            dfs(root.left,number)
            dfs(root.right,number)

        dfs(root,0)
        return self.sum_no
            