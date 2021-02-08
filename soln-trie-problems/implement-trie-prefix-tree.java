/*
https://leetcode.com/problems/implement-trie-prefix-tree/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class TrieNode{
    char val;
    int count;
    int endsHere;
    TrieNode[] links;
    
    TrieNode(){
        links=new TrieNode[26];
    }
    
    TrieNode getNode(int index){
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
        for(int i=0;i<word.length();i++){
            index=word.charAt(i)-'a';
            if(curr.links[index]==null){
                curr.links[index]=new TrieNode().getNode(index);
            }
            curr.links[index].count++;
            curr=curr.links[index];
        }
        curr.endsHere++;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        int index;
        for(int i=0;i<word.length();i++){
            index=word.charAt(i)-'a';
            if(curr.links[index]==null)
                return false;
            curr=curr.links[index];
        }
        return curr.endsHere>0;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        int index;
        for(int i=0;i<prefix.length();i++){
            index=prefix.charAt(i)-'a';
            if(curr.links[index]==null)
                return false;
            curr=curr.links[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */