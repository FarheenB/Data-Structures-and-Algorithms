/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        preorder(root);
    }
    
    public void preorder(TreeNode root){
        if(root==null)
            return;
        
        preorder(root.left);
        preorder(root.right);
        
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=left;
        
        while(root.right!=null)
            root=root.right;
        root.right=right;       
        
    }
}