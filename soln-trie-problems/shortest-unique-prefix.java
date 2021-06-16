/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/shortest-unique-prefix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class TrieNode {
    char val;
    int count;
    int endsHere;
    TrieNode[] links;
    
    TrieNode() {
        links=new TrieNode[26];
    }
    
    TrieNode getNode(int index) {
        TrieNode newNode=new TrieNode();
        newNode.val=(char)('a'+index);
        newNode.count=newNode.endsHere=0;
        for(int i=0;i<26;i++)
            newNode.links[i]=null;
        return newNode;       
    }
}

class Trie {
    TrieNode root;
 
    public Trie() { 
        root=new TrieNode().getNode('/'-'a');
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        int index;
        for(int i=0;i<word.length();i++) {
            index=word.charAt(i)-'a';
            if(curr.links[index]==null) {
                curr.links[index]=new TrieNode().getNode(index);
            }
            curr.links[index].count++;
            curr=curr.links[index];
            
        }
        curr.endsHere++;
    }
    
    public String getPrefix(String word) {
        TrieNode curr=root;
        String pre="";
        int index;
        for(int i=0;i<word.length();i++){
            index=word.charAt(i)-'a';
            if(curr.links[index].count==1 || curr.links[index].endsHere>0) {
                pre+=word.charAt(i);
                return pre;
            }    
            pre+=word.charAt(i);
            curr=curr.links[index];
        }
        return pre;
    }
}

public class Solution {
    public String[] prefix(String[] A) {
        String[] uni_prefix=new String[A.length];
        Trie trie=new Trie();
        for(String word:A){
            trie.insert(word);
        }
        for(int i=0;i<A.length;i++) {
            
            String str=trie.getPrefix(A[i]);
            uni_prefix[i]=str;
        }
        return uni_prefix;
    }
}
