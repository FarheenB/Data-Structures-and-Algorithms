/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/cousins-in-binary-tree/
 https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
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
    TreeNode xpar,ypar;
    int xdepth,ydepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return xdepth==ydepth && xpar!=ypar;
    }
    
    public void dfs(TreeNode root,TreeNode parent,int x,int y,int depth){
        if(root==null || (xpar!=null && ypar!=null)){
           return; 
        }
        if(root.val==x){
            xpar=parent;
            xdepth=depth;
        }
        else if(root.val==y){
            ypar=parent;
            ydepth=depth;
        }
        dfs(root.left,root,x,y,depth+1);
        dfs(root.right,root,x,y,depth+1);
        
    }
}

