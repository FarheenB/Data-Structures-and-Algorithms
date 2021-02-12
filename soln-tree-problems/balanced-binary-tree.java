/*
https://leetcode.com/problems/balanced-binary-tree/
https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
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
    boolean balance;
    public boolean isBalanced(TreeNode root) {
        balance=true;
        height(root);
        return balance;
    }
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        if(balance && (int)Math.abs(l-r)<=1)
            balance=true;
        else
            balance=false;
        
        //find height of subtree
        return Math.max(l,r)+1;        
    }        
}