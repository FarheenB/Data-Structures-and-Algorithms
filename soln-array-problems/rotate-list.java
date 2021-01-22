/*
https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        
        int count=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            count++;
        }
        tail.next=head;
        k=k%count;
        int i=1;
        ListNode p=head;

        while(i<(count-k)){
            i++;
            p=p.next;
        }
        head=p.next;
        p.next=null;
        return head;
    }
}