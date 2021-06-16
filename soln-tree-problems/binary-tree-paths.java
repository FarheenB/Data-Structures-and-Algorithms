/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/binary-tree-paths
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
    List<String> result=new ArrayList<>();
    StringBuilder str=new StringBuilder();
    List<Integer> path=new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return result;
        dfs(root);
        return result;
    }
    
    public void dfs(TreeNode root){
        if(root==null)
            return;
       
        path.add(root.val);
        
        if(root.left==null && root.right==null){           
            String format_path=getPath(path);
            result.add(format_path);
        }   

        dfs(root.left);
        dfs(root.right);

        int index=path.lastIndexOf(root.val);
        path.remove(index);
    }
    
    public String getPath(List<Integer> path){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<path.size();i++){
            str.append(path.get(i));
            if(i!=path.size()-1)
                str.append("->");
        }
        return str.toString();
    }
}
