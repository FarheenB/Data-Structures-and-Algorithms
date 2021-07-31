/**
 @author Farheen Bano
  
 References-
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
        ListNode fastptr=head;
        
        while(fastptr!=null && fastptr.next!=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
            if(fastptr==slowptr)
                return true;
        }
        return false;
    }
}
