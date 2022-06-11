# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        res=[]
        
        if root==None:
            return res
        
        queue=[root]
        
        while queue:            
            size=len(queue)
            summ=0

            for _ in range(size):
         
    #           step 1: remove the cur node
                cur_node=queue.pop(0)
        
    #           step 2: add cur node to the sum  of cur levels 
                summ+=cur_node.val
        
    #           step 3: get children of curr node
                if cur_node.left:
                    queue.append(cur_node.left)
                if cur_node.right:
                    queue.append(cur_node.right)
        
            res.append(summ/size)
            
        return res

            
            
            
            
        