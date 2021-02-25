/*
https://leetcode.com/problems/delete-nodes-and-return-forest
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
    List<TreeNode> result=new ArrayList<>();
    HashSet<Integer> set=new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int n:to_delete)
            set.add(n);
        
        dfs(root);
        if(!set.contains(root.val))
            result.add(root);
        return result;
    }
    
    public TreeNode dfs(TreeNode root){
        if(root==null)
            return root;
        
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        
        if(set.contains(root.val)){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }        
        return root;
    }
}