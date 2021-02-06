/*
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,0,0);

        //get each column
        for(int key:map.keySet()){
            TreeMap<Integer, List<Integer>> levels=map.get(key);
            List<Integer> list=new ArrayList<>();

            //get each row
            for(int level:levels.keySet()){
                List<Integer> values_list=levels.get(level); 
                Collections.sort(values_list);

                //get each value
                for(int num:values_list){
                    list.add(num);                    
                }
            }
            result.add(list);
        }
        return result;
    }
    
    public void dfs(TreeNode root, int col, int row){
        if(root==null)
            return;
        
        //add root value at appropriate row and column position
        TreeMap<Integer, List<Integer>> levels;
        List<Integer> values_list;
        if(map.containsKey(col)){
            levels=map.get(col);
            if(levels.containsKey(row))
                values_list=levels.get(row);                
            else
                values_list=new ArrayList<>();
        }
        else{
            levels=new TreeMap<>();
            values_list=new ArrayList<>();
        }
        values_list.add(root.val);
        levels.put(row,values_list);
        map.put(col,levels);

        // preorder DFS traversal
        dfs(root.left,col-1,row+1);
        dfs(root.right,col+1,row+1);
    }
}