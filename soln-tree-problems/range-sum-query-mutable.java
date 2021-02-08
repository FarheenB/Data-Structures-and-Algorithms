/*
https://leetcode.com/problems/range-sum-query-mutable/

NOTE: Using Segment Trees
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode{
    int sum;
    int start,end;
    TreeNode left,right;
    
    public TreeNode(int start, int end){
        this.start=start;
        this.end=end;
        this.left=null;
        this.right=null;
    }
}

class NumArray {

    TreeNode root=null;
    public NumArray(int[] nums) {
        root = buildTree(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        updateTree(root,index,val);
    }
    
    public int sumRange(int left, int right) {
        return queryTree(root,left,right);        
    }
    
    public TreeNode buildTree(int[] nums, int start, int end){
        if(start>end)
            return null;
        
        TreeNode newNode=new TreeNode(start,end);
        
        if(start==end)
            newNode.sum=nums[start];
        else{
            int mid=start+(end-start)/2;
            newNode.left=buildTree(nums,start,mid);
            newNode.right=buildTree(nums,mid+1,end);
            newNode.sum=newNode.left.sum+newNode.right.sum;
        }
        return newNode;
    }
    
    public void updateTree(TreeNode root, int index,int val){
        if(root.start==root.end)
            root.sum=val;
        
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(index<=mid)
                updateTree(root.left,index,val);
            else
                updateTree(root.right,index,val);
            root.sum=root.left.sum+root.right.sum;
        }        
    }
    
    public int queryTree(TreeNode root, int left, int right){
        if(root.start==left && root.end==right)
            return root.sum;
        int mid=root.start+(root.end-root.start)/2;
        if(right<=mid)
            return queryTree(root.left,left,right);
        else if(left>=mid+1)
            return queryTree(root.right,left,right);
        else
            return queryTree(root.left,left,mid)+queryTree(root.right,mid+1,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */