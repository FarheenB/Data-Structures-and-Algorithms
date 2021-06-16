/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-univalue-path/
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
    int max_len=Integer.MIN_VALUE;
    int count=0;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return max_len;
    }
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        int leftLength=0;
        int rightLength=0;
        if(root.left!=null && root.left.val==root.val){
            leftLength+=left+1;
        }
        if(root.right!=null && root.right.val==root.val){
            rightLength+=right+1;
        }
        max_len=Math.max(max_len,leftLength+rightLength);
        return Math.max(leftLength,rightLength);
    }
}
