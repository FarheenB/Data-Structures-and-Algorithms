/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/palindrome-linked-list/
 https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st=new Stack<Integer>();
        if(head==null || head.next==null)
            return true;
        ListNode slow= head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            st.push(slow.val);
            slow =slow.next;
            fast =fast.next.next;           
 
        }    
    
        if(fast!=null){
            
            slow=slow.next;

        }
    
        while(slow!=null){
            if(st.empty())
            {
                return false;
            }
            int num=st.pop().intValue();
            if(slow.val!=num){
                return false;
            }
            slow=slow.next;
        }
        return true;
    }
}