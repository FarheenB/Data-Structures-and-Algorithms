/*
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://leetcode.com/problems/insert-into-a-binary-search-tree/
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode=new TreeNode(val);
        
        if(root==null){
            root=newNode;
            return root;
        }
        
        TreeNode p=root;
        while(true)
        {
            if(val<p.val){
                if(p.left!=null)
                    p=p.left;
                else{
                    p.left=newNode;
                    break;}
            }
            else
                if(p.right!=null)
                    p=p.right;
                else{
                    p.right=newNode;
                    break;
                }
        }
        return root;
       
    }
}