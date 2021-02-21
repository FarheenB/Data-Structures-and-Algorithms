/*
https://leetcode.com/problems/swap-nodes-in-pairs/
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
    
        ListNode p=head;
        ListNode q=p.next;

        while(p!=null && q!=null){
            int temp=p.val;
            p.val=q.val;
            q.val=temp;
            
            p=q.next;
            if(p!=null)
                q=p.next;
        }
        return head;
    }
}