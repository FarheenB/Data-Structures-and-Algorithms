/*
https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return res;
        res.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }
}