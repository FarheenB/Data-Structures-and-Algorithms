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
        if(head==null)
            return false;
        ListNode slowptr=head;
        ListNode fastptr=head.next;
        
        while(fastptr!=null && fastptr.next!=null){
            if(fastptr==slowptr)
                return true;
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        return false;
    }
}