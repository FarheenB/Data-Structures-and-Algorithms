/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/univalued-binary-tree/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null){
            return true;
        }
        int val=root.val;
        return check(root,val);
    }
    
    public boolean check(TreeNode root, int val){
        if(root==null)
            return true;
        if(root.val!=val)
            return false;
        return check(root.left,val) && check(root.right,val);
    }
}
