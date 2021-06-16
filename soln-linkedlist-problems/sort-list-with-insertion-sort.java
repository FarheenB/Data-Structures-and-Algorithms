/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/insertion-sort-list/
 https://leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode prevNode = dummyNode;

            while (prevNode.next != null && prevNode.next.val < currentNode.val) {
                prevNode = prevNode.next;
            }

            ListNode nextNode = currentNode.next;

            currentNode.next = prevNode.next;
            prevNode.next = currentNode;
            currentNode = nextNode;
        }

        return dummyNode.next;
    }
}
