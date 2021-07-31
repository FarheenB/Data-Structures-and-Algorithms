/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode dummyHead=new ListNode();
        dummyHead.next=head;
        
        ListNode p=head;
        ListNode q=dummyHead;

        while(p!=null){
            if(p.next!=null && p.val==p.next.val){
                while(p.next!=null && p.val==p.next.val)
                        p=p.next;
                q.next=p.next;
            }
            else
                q=q.next;
            p=p.next;
        }
        return dummyHead.next;
    }
}
