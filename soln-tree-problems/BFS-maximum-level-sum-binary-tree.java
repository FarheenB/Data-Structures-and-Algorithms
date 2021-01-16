/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
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
     List<List<Integer>> order=new ArrayList<>();
        int level=-1;
        if(root==null){
            return -1;
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
        int max=Integer.MIN_VALUE;
        int l=-1;
        for(int i=0;i<order.size();i++)
        {
            int sum=0;

            for(int x:order.get(i)){
                sum+=x;
            }
            if(max<sum){
                max=sum;
                l=i+1;
            }
        }
        return l;
    }
}