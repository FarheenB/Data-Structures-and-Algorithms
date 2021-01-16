/*
https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    List<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return res;
        inorderTraversal(root.left);
        res.add(root.val);

        inorderTraversal(root.right);

        return res;
    }
}