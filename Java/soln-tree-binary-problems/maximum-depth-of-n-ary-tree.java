/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 https://www.geeksforgeeks.org/depth-n-ary-tree/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max=0;
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        findMaxDepth(root,1);
        return max;
        
    }
    
  public void findMaxDepth(Node root,int depth)
    {
        if(root.children.size()==0)
        {
            max= Math.max(depth,max);
            return;
        }
        for(Node temp:root.children)
        {
            findMaxDepth(temp,depth+1);
        }
    }
}
