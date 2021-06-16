/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/smallest-string-starting-from-leaf/
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
    List<Character> path=new ArrayList<>();
    String result="z";

    public String smallestFromLeaf(TreeNode root) {
        if(root==null)
            return "";
        dfs(root);
        return result;
    }
    
    
    public void dfs(TreeNode root){
        if(root==null)
            return;
        
        path.add((char)('a'+root.val)); 
        
        if(root.left==null && root.right==null){
            StringBuilder str=new StringBuilder();
            for(char ch:path)
                str.append(ch);
            
            String format_path=str.reverse().toString();
            result=result.compareTo(format_path)>0?format_path:result;
        }  
        
        dfs(root.left);
        dfs(root.right); 
        int index=path.lastIndexOf((char)('a'+root.val));
        path.remove(index);
    }
}
