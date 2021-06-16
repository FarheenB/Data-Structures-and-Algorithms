/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/add-two-numbers/
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

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = newHead;
        int carry = 0;
        while (p != null || q != null) {
            int a = (p != null) ? p.val : 0;
            int b = (q != null) ? q.val : 0;
            
            int sum = carry + a + b;
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (p != null) 
                p = p.next;
            if (q != null) 
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
