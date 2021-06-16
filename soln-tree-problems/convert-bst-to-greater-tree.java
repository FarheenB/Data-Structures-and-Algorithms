/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/convert-bst-to-greater-tree
 https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    
    public void dfs(TreeNode root){
        if(root==null)
            return;

        dfs(root.right);
        root.val=root.val+sum;
        sum=root.val;
        dfs(root.left);

    }
}
