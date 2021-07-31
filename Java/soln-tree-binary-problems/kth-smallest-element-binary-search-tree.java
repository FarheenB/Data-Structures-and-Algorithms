/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    int value=0;
    int pos;
    public int kthSmallest(TreeNode root, int k) {
        pos=k;
        inorder(root);
        return value;
    }
    
    public void inorder(TreeNode root){
        if(root==null || pos<=0)
            return;
        inorder(root.left);
        pos--;
        if(pos==0){
            value = root.val;
            return;
        }        
        inorder(root.right);

    }
}
