/*
https://practice.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1
https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    int sum=0;

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,0);
        return sum;
    }
    
    public void dfs(TreeNode root, int number){
        if(root==null)
            return;
        int digit=root.val;  
        number=number*10+digit;
        
        if(root.left==null && root.right==null){ 
            sum+=number;
            return;
        }
        
        dfs(root.left,number);
        dfs(root.right,number);
    }
}
