/*
https://leetcode.com/problems/path-sum-ii/

Note: Find all root to leaf path equals to sum
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
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return result;
        dfs(root,targetSum);
        return result;
    }
    
    
    public void dfs(TreeNode root, int targetSum){
        if(root==null)
            return;
        
        path.add(root.val);   
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                ArrayList<Integer> list=new ArrayList<>(path);
                result.add(list);  
            }
        }  
        
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val); 
        
        int index=path.lastIndexOf(root.val);
        path.remove(index);
    }
}