/*
https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Tree
{
    int height(Node root) 
    {
         if(root==null)
            return 0;
        int leftTree=height(root.left);
        int rightTree=height(root.right);
        
        return Math.max(leftTree,rightTree)+1;
    }   
}
