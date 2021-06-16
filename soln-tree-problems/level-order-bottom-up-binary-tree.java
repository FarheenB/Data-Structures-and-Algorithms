/**
 @author Farheen Bano
  
 References-
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
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }          
            result.add(0,list);
        }
        return result;
    }
}
