/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/binary-tree-right-side-view/
 https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();       

        if(root==null)
            return list;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            list.add(queue.peek().val);
            int size=queue.size();
            
            for(int i=1;i<=size;i++){
                TreeNode x=queue.poll();
                if(x.right!=null){
                    queue.offer(x.right);
                }
                if(x.left!=null){
                    queue.offer(x.left);
                }
            }
        }
        return list;
    }
}
