/*
https://leetcode.com/problems/house-robber-iii
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
    Map<TreeNode, Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        return traverse(root);
    }
    
    public int traverse(TreeNode root){
        if(root==null)
            return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int sum=root.val;
        
        if(root.left!=null){
            sum+=traverse(root.left.left);
            sum+=traverse(root.left.right);              
        }
        if(root.right!=null){
            sum+=traverse(root.right.left);
            sum+=traverse(root.right.right);              
        }
 
        int next_sum=traverse(root.left)+traverse(root.right);
        int res=Math.max(sum,next_sum);
        map.put(root,res);        
        return res;
    } 
}