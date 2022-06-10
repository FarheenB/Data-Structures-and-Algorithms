# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode], parentVal = None) -> int:
        if not root:
            return 0
        
		# """
		# 	Initialize the parentVal to be none and keep multiplying it with 10 everytime its child is visited so that we can add the values in order as expected in question. Then add the value of child and return.
		# """
		
        if parentVal is None:
            parentVal = root.val
        else:
            parentVal *= 10
            parentVal += root.val
        
        if root.left is None and root.right is None:
            return parentVal
        
        return self.sumNumbers(root.left, parentVal) + self.sumNumbers(root.right, parentVal)