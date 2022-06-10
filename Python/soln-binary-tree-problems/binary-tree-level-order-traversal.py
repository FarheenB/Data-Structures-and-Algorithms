# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        queue = [[root]]
        
        output = []
        while queue:
            level = queue.pop(0)
            
            output.append([item.val for item in level])
            nextLevel = []
            for item in level:
                if item.left:
                    nextLevel.append(item.left)
                if item.right:
                    nextLevel.append(item.right)
            
            if nextLevel:
                queue.append(nextLevel)
                
        return output        