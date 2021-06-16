/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/path-sum/

 Note: Find root to leaf path equals to sum
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
    boolean flag=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        dfs(root,targetSum);
        return flag;
    }
    
    
    public void dfs(TreeNode root, int targetSum){
        if(root==null)
            return;
            
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                flag=true;
                return;
            }                
        }      
        
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val);        
    }
}
