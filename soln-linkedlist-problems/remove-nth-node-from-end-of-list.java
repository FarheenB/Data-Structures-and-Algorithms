/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;        
        ListNode slowPtr=dummyHead;
        ListNode fastPtr=dummyHead;

        int i=1;
        while(i<=n+1){
            fastPtr=fastPtr.next;
            i++;
        }
        
        while(fastPtr!=null){
            fastPtr=fastPtr.next;
            slowPtr=slowPtr.next;     
        }
        slowPtr.next=slowPtr.next.next;   
        return dummyHead.next;
    }
}