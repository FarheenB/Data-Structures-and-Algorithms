/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/delete-leaves-with-a-given-value/
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return root;
        return dfs(root,target);
    }    
    
    public TreeNode dfs(TreeNode root, int target){
        if(root==null)
            return root;                       
        
        root.left=dfs(root.left,target);
        root.right=dfs(root.right,target); 
        
        if(root.left==null && root.right==null && root.val==target)
            root=null;
        return root;
    }
}
