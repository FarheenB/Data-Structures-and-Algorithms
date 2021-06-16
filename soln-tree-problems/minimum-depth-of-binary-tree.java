/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int rightnodes= minDepth(root.right);
        int leftnodes= minDepth(root.left);
        if(Math.min(leftnodes,rightnodes)!=0){
            return Math.min(leftnodes,rightnodes)+1;
        }
        //for skewed tree
        else
            return Math.max(leftnodes,rightnodes)+1;        
    }
}


