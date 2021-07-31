/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 https://leetcode.com/problems/validate-binary-search-tree/
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
    
    TreeNode prev;
    boolean result;
    
    public boolean isValidBST(TreeNode root) 
    { 
        result=true;
        inorder(root);
        return result;
    }        

    public void inorder(TreeNode root){
        if(root==null || !result){            
            return;
        }
        
        inorder(root.left);

        //maintain inorder
        if (prev != null && result) 
            result=prev.val<root.val; 
        prev = root; 
        inorder(root.right);         
    }
}
