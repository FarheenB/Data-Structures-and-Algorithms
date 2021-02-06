/*
https://leetcode.com/problems/find-bottom-left-tree-value/
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
    public int findBottomLeftValue(TreeNode root) {  
        int result=-1;
        if(root==null)
            return result;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            result=queue.peek().val;
            int size=queue.size();
            
            for(int i=1;i<=size;i++){
                TreeNode x=queue.poll();
                if(x.left!=null){
                    queue.offer(x.left);
                }
                if(x.right!=null){
                    queue.offer(x.right);
                }
            }
        }
        return result;
    }
}