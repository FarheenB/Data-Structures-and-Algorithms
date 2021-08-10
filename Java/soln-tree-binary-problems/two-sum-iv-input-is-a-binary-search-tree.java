/**
 @author Farheen Bano

 Date 10-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-iv-input-is-a-bst
*/

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
    HashSet<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        set=new HashSet<>();
        return search(root,k);
    }
    
    public boolean search(TreeNode root, int k){
        if(root==null)
            return false;
        
        if(set.contains(root.val))
            return true;
        
        set.add(k-root.val);
        return search(root.left,k) || search(root.right,k); 
    }
}