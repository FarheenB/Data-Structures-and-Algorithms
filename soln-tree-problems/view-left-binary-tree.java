/*
https://www.geeksforgeeks.org/print-left-view-binary-tree/
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
    int max_level = 0;
    List<Integer> list=new ArrayList<>();

    public List<Integer> leftSideView(TreeNode root) {
    
        leftView(root,1);
        return list;
    }    
 
    // recursive function to print left view
    public void leftView(TreeNode node, int level)
    {
        if (node == null)
            return;
 
        if (max_level < level) {
            list.add(node.val);
            max_level = level;
        }
 
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }
}