/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal=root.val;
        int pVal=p.val;
        int qVal=q.val;
        
        if(pVal<parentVal && qVal<parentVal){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(pVal>parentVal && qVal>parentVal){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
        
    }
}
