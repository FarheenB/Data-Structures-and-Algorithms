/*
https://leetcode.com/problems/construct-string-from-binary-tree/
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
    StringBuilder str=new StringBuilder();
    
    public String tree2str(TreeNode t) {
        traversal(t);
        return str.toString();
    }
    
    public void traversal(TreeNode root){
        if(root==null)
            return;
        str.append(root.val);
        
        if(root.left==null && root.right==null)
            return;
            
        if(root.left!=null || (root.left==null && root.right!=null))
        {
            str.append("(");
            traversal(root.left);
            str.append(")");
        }
        if(root.right!=null)
        {
            str.append("(");
            traversal(root.right);
            str.append(")");
        }
    }
}