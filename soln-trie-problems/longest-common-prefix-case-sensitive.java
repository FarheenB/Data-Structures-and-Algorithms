/*
https://www.interviewbit.com/problems/longest-common-prefix/
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
        links=new TrieNode[52];
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
        int index=-1;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch))
                index=word.charAt(i)-'a';
            else
                index=(word.charAt(i)-'A')+26;
                
            if(curr.links[index]==null){
                curr.links[index]=new TrieNode().getNode(index);
            }
            curr.links[index].count++;
            curr=curr.links[index];
        }
        curr.endsHere++;
    }
    
    public String getCommonPrefix(String word, int occurrence){
        TrieNode curr=root;
        String pre="";
        int index=-1;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch))
                index=word.charAt(i)-'a';
            else
                index=(word.charAt(i)-'A')+26;
                
            if(curr.links[index].count==occurrence)
                pre+=word.charAt(i);
            else
                return pre;
            curr=curr.links[index];
        }
        return pre;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        
        Trie trie=new Trie();
        for(String word:strs){
            trie.insert(word);
        }
        return trie.getCommonPrefix(strs[0], strs.length);
    }
}