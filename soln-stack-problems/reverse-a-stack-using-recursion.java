/*
https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static Stack<Character> stack=new Stack<>();
	public static void reverseStack(){
	    if(stack.isEmpty())
	        return;
	        
	    char n=stack.pop();
	    reverseStack();
	    insertAtBottom(n);  
	}
	
	public static void insertAtBottom(char n){
	    if(stack.isEmpty())
	        stack.push(n);
	    else{
	        char x=stack.pop();
	        insertAtBottom(n);
	        stack.push(x);
	    }
	}
}