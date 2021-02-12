/*
https://leetcode.com/problems/copy-list-with-random-pointer/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> visited = new HashMap<Node, Node>();

       //iterate once to deep copy all nodes and put in hashmap
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            visited.put(curr, newNode);
            curr = curr.next;
        }

        Node currOld = head;
        Node currNew = visited.get(head);
        while(currOld != null) {
            currNew.next = (currOld.next == null)? null : visited.get(currOld.next);
            currNew.random = (currOld.random == null)? null : visited.get(currOld.random);

            currOld = currOld.next;
            currNew = currNew.next;
        }

        return visited.get(head);
    }
}