# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.invert(root)

    
    def invert(self,root):
        if(root==None):
            return root
        
        left=self.invert(root.left)
        right=self.invert(root.right)
        
        root.left=right
        root.right=left
        return root