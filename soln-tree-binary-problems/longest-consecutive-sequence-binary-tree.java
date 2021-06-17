/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
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
    public int longestConsecutive(TreeNode root) {
        int[] max=new int[1];
        dfs(root,0,0,max);
        return max[0];
    }
    
    public void dfs(TreeNode root, int count, int target, int[] max){
        if(root==null)
            return;
        
        if(root.val==target)
            count++; 
        else
            count=1;
        
        max[0]=Math.max(max[0],count);
        
        dfs(root.left, count, root.val+1,max);
        dfs(root.right, count, root.val+1,max);            
    } 
}
