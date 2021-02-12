/*
https://leetcode.com/problems/diameter-of-binary-tree/
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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        depth(root);
        return ans;
    }
    
    public int depth(TreeNode node){
        if(node==null)
            return 0;
    
        int leftTree = depth(node.left);
        int rightTree = depth(node.right);
        
        ans = Math.max(ans, leftTree+rightTree);
        //get max height of each subtree
        return Math.max(leftTree, rightTree) + 1;
    }
}