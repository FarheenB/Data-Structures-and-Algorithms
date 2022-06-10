# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res=[]

        def postorder(root):
            if root==None:
                return res
            postorder(root.left)
            postorder(root.right)
            res.append(root.val)

            return res
        
        postorder(root)
        return res