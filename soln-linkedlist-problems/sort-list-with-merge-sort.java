/*
https://www.interviewbit.com/problems/sort-list/
https://leetcode.com/problems/sort-list/

NOTE:   Using Merge Sort
        Time : O(nlogn)
        Space: O(1)- constant space
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
     public ListNode sortList(ListNode head) {
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
        
        ListNode left_side=sortList(head);
        ListNode right_side=sortList(slow);

        return merge(left_side, right_side);
        
    }
    
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode sortedDummy=new ListNode(0);
        ListNode current_node=sortedDummy;
        
        while(left!=null && right!=null){
            if(left.val<right.val){
                current_node.next=left;
                left=left.next;
            }
            else{
                current_node.next=right;
                right=right.next;
            }  
            current_node=current_node.next;
        }
        current_node.next=left!=null?left:right;
        return sortedDummy.next;
    }
}
