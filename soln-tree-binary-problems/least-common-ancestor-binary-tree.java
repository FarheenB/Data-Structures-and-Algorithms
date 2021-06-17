/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 https://www.interviewbit.com/problems/least-common-ancestor/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int lca(TreeNode root, int B, int C) {
        if(root==null)
            return -1;
            
        if(!(isExists(root,B) && isExists(root,C)))
            return -1;
            
        TreeNode lowest_common_ancestor=search(root,B,C);
        return lowest_common_ancestor==null?-1:lowest_common_ancestor.val;
    }
    
    public TreeNode search(TreeNode root, int B, int C){
        if(root==null)
            return null;
            
        if(root.val==B || root.val==C){
            return root;
        }
        
        TreeNode leftSearch=search(root.left,B,C);
        TreeNode rightSearch=search(root.right,B,C);
        
        if(leftSearch==null && rightSearch==null)
            return null;
        if(leftSearch!=null && rightSearch!=null)
            return root;
        return leftSearch == null ? rightSearch : leftSearch;
    }
    
    public boolean isExists(TreeNode root, int x){
        if(root==null)
            return false;
        if(root.val==x)
            return true;
        return isExists(root.left, x) || isExists(root.right, x);        
    }
}
