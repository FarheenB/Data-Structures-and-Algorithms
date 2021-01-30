/*
https://leetcode.com/problems/merge-two-sorted-lists/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p=l1;
        ListNode q=l2;
        ListNode resultHead=null;
        ListNode dummyNode=new ListNode();
        resultHead=dummyNode;
        
        while (p != null && q != null) {
            
            if (p.val <= q.val) {
                dummyNode.next = p;
                p = p.next;
            } 
            else {
                dummyNode.next = q;
                q = q.next;
            }
            dummyNode = dummyNode.next;
        }

        dummyNode.next = p == null ? q : p;
        return resultHead.next;
    }
}