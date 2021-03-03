/*
https://leetcode.com/problems/linked-list-cycle-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {   
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        
        ListNode intersect=getIntersect(head);
        if(intersect==null)
            return null;
        
        ListNode ptr1=head;
        ListNode ptr2=intersect;
        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }
    
    public ListNode getIntersect(ListNode head){
        ListNode slowptr=head;
        ListNode fastptr=head;
        
        while(fastptr!=null && fastptr.next!=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
            if(fastptr==slowptr)
                return slowptr;
        }
        return null;
    }
}