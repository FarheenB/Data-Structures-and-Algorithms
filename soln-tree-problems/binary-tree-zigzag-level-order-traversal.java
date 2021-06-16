/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
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
    List<List<Integer>> result=new ArrayList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return result;
        bfs(root);
        return result;
    }
    
    public void bfs(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        int level=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                int x=node.val;
                
                if(level%2==0){
                    list.add(x);
                }
                else{
                    list.add(0,x);
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
            result.add(list);
        }
    }
}
