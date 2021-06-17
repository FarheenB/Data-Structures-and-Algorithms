/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/leaf-similar-trees/
 https://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        traverseLeaf(root1,list1);
        traverseLeaf(root2,list2);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i))
                return false;
        }
        return true;
    }
    
    public void traverseLeaf(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        traverseLeaf(root.left, list);
        traverseLeaf(root.right, list);
    }
}
