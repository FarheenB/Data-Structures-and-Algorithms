/*
https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
https://leetcode.com/problems/sum-of-left-leaves/
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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        traverse(root,false);
        return sum;
    }    
    
    public void traverse(TreeNode node, boolean bool){
        if(node.left==null && node.right==null)
            sum+=bool?node.val:0;
        
        if(node.left!=null)
            traverse(node.left,true);

        if(node.right!=null)
            traverse(node.right,false);
        
    }
}