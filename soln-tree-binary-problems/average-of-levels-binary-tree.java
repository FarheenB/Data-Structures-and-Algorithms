/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/averages-levels-binary-tree/
 https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average=new ArrayList<>();
        if(root==null)
            return average;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            
            List<Integer> list=new ArrayList<Integer>();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                sum+=node.val;
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }       
            average.add((double)(sum/list.size()));            
        }        
        return average;
    }
}
