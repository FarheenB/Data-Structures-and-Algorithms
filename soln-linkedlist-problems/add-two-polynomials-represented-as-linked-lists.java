/*
https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/
*/

/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode p=poly1;
        PolyNode q=poly2;
        PolyNode resultHead=null;
        PolyNode dummyNode=new PolyNode();
        resultHead=dummyNode;
        int power;
        int coeff;
        
        while(p!=null && q!=null){
         
            if(p.power==q.power){
                power=p.power;
                coeff=p.coefficient+q.coefficient;
                p=p.next;
                q=q.next;
            }
            else{
               
                if(p.power>q.power){
                    power=p.power;
                    coeff=p.coefficient;
                    p=p.next;                    
                }
                else{
                    power=q.power;
                    coeff=q.coefficient;
                    q=q.next;                    
                }
            }
            if(coeff!=0){
                PolyNode newNode=new PolyNode(coeff,power);
                dummyNode.next=newNode;
                dummyNode=newNode;                
            }              
        }   
        dummyNode.next=p==null?q:p;
        return resultHead.next;
    }
}