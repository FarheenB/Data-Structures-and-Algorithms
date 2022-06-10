# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) == 0:
            return None
        max_value = max(nums)
        max_index = nums.index(max_value)
        root = TreeNode(max_value)
        root.left = self.constructMaximumBinaryTree(nums[ : max_index])
        root.right = self.constructMaximumBinaryTree(nums[max_index + 1 : ])
        return root   