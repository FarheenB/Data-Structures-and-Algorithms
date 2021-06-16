/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/search-in-a-binary-search-tree/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

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
    TreeNode p;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return root;
        }
        if(val==root.val)
            return root;
        return val<root.val ? searchBST(root.left,val):searchBST(root.right,val);
    }
}
