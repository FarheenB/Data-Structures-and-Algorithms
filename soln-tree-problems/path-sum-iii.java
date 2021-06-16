/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/path-sum-iii/

 Note: The path does not need to start or end at the root or a leaf
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
    int count=0;
    ArrayList<Integer> list=new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        dfs(root,sum);
        return count;
    }
    
    public void dfs(TreeNode root, int targetSum){
        if(root==null)
            return;

        list.add(root.val);
        
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        
        int sum=0;
        for(int i=list.size()-1;i>=0;i--){
            sum+=list.get(i);
            if(sum==targetSum){
                count++;
            }
        }
        
        list.remove(list.size()-1);
        
    }
}
