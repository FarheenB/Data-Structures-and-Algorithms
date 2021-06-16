/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return createBST(head);
    }
    
    public ListNode findMiddleElement(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        return slow;
    }
    
    public TreeNode createBST(ListNode head){
        if(head==null){
            return null;
        }
        ListNode mid=findMiddleElement(head);
        TreeNode node=new TreeNode(mid.val);
        
        if(head==mid){
            return node;
        }
        node.left = createBST(head);
        node.right = createBST(mid.next);
        return node; 
    }
}
