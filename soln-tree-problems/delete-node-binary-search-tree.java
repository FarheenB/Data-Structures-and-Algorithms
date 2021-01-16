/*
https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
https://leetcode.com/problems/delete-node-in-a-bst/
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(key>root.val)
            root.right=deleteNode(root.right,key);
        else if(key<root.val)
            root.left=deleteNode(root.left,key);
        else if(root.left==null && root.right==null){
            root=null;
        }
        else if(root.left!=null){
            //inorder predecessor
            root.val=inorder_predecessor(root);
            root.left=deleteNode(root.left,root.val); 
        }
        else{
            //inorder successor
            root.val=inorder_successor(root);
            root.right=deleteNode(root.right,root.val); 
        }
        return root;
    }
    
    int inorder_predecessor(TreeNode root){
        root=root.left;
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    } 

    int inorder_successor(TreeNode root){
        root=root.right;
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    } 
    
}