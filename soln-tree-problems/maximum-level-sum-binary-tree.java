/*
https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return -1;
        
        int max_sum=Integer.MIN_VALUE;
        int max_level=0;
        int level=0;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            
            List<Integer> list=new ArrayList<Integer>();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                sum+=node.val;
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }     
            if(max_sum<sum){
                max_sum=sum;
                max_level=level;
            }           
        }        
        return max_level;
    }
}