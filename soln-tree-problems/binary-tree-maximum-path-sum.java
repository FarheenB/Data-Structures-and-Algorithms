/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max_sum=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return max_sum;
    }
        
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        int straightPath=Math.max(Math.max(left,right)+root.val,root.val);
        int rootPath=Math.max(left+right+root.val,root.val);
        max_sum=Math.max(max_sum,Math.max(straightPath,rootPath));
        
        return straightPath;
    }
}
