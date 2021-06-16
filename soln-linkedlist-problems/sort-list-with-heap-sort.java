/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sort-list/

NOTE:   Using Heap Sort
        Time : O(nlogn)
        Space: O(n)
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
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        ListNode p=head;
        ListNode dummyNode=new ListNode();
        ListNode newHead=dummyNode;
        while(p!=null){
            minHeap.add(p.val);
            p=p.next;
        }
        
        while(!minHeap.isEmpty()){
            ListNode newNode=new ListNode(minHeap.remove(),null);
            dummyNode.next=newNode;
            dummyNode=newNode;
        }
        return newHead.next;
    }
}
