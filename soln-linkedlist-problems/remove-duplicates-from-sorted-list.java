/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-duplicates-from-sorted-list
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
        ListNode p=head;
        while(p.next!=null){
            if(p.val==p.next.val)
                p.next=p.next.next;
            else
                p=p.next;
        }
        return head;
    }
}
