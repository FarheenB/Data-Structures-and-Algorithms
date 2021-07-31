/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(ListNode list:lists){
            while(list!=null){
                minHeap.add(list.val);
                list=list.next;
            }
        }
        
        ListNode dummyNode=new ListNode();
        ListNode head=dummyNode;
        
        while(!minHeap.isEmpty()){
            ListNode newNode=new ListNode(minHeap.remove());
            dummyNode.next=newNode;
            dummyNode=newNode;
        }
        return head.next;    
    }
}
