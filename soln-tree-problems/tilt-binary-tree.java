/*
https://leetcode.com/problems/binary-tree-tilt/
https://www.geeksforgeeks.org/tilt-binary-tree/
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
    int sum;
    public int findTilt(TreeNode root) {
        sum=0;
        postOrder(root);
        return sum;
    }
    
    
    public int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }
        int r=postOrder(root.right);
        int l=postOrder(root.left);        
        sum+=(int)Math.abs(r-l);
        return root.val+r+l;      
        
    }
}