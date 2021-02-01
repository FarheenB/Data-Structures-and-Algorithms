/*
https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1
https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode=new Node(insertVal);
        
        if(head==null){
            head=newNode;
            newNode.next=newNode;
            return head;
        }
        
        Node max=head;
        while(max.next!=head && max.val<=max.next.val){
            max=max.next;
        }
        
        //Since cyclic linked list
        Node min=max.next;
        Node cur=min;
        
        if(insertVal>=max.val || insertVal<=min.val){
            newNode.next=min;
            max.next=newNode;
        }
        else{
            while(cur.next.val<insertVal){
                cur=cur.next;
            }
            newNode.next=cur.next;
            cur.next=newNode;
        }        
        return head;
    }
}