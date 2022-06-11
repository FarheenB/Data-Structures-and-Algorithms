# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        def invert(root):
            if root is None:
                return root
            
            left=invert(root.left)
            right=invert(root.right)
            
            root.left=right
            root.right=left
            
            return root
        
        return invert(root)
          