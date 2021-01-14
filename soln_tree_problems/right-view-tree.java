/*
https://leetcode.com/problems/binary-tree-right-side-view/
https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) 
            return rightside;
        
        helper(root, 0);
        return rightside;
    }
}