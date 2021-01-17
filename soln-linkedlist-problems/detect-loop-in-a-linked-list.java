/*
https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
https://leetcode.com/problems/linked-list-cycle/
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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode p=head;
        ListNode q=head.next;

        while(p!=q){
            if(q==null || q.next==null){
                return false;
            }
            p=p.next;
            q=q.next.next;
        }
        return true;
    }
}