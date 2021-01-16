/*
https://www.geeksforgeeks.org/reverse-level-order-traversal/
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> order=new ArrayList<>();
        int level=-1;
        if(root==null){
            return order;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            level++;
            int s=queue.size();
            if(s!=0)
                order.add(level, new ArrayList<Integer>());
            for(int i=0;i<s;i++){
                TreeNode x=queue.remove();
                order.get(level).add(x.val);
                if(x.left!=null){
                    queue.add(x.left);
                }
                if(x.right!=null){
                    queue.add(x.right);
                }        
            }          
            
        }
        List<List<Integer>> bottom_up=new ArrayList<>();
        int j=0;
        for(int i=order.size()-1;i>=0;i--)
        {
            bottom_up.add(j,new ArrayList<Integer>(order.get(i)));
            j++;
        }
        return bottom_up;
    }
}