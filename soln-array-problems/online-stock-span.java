/*
https://leetcode.com/problems/online-stock-span/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int value;
    int index;
    
    public Pair(int value, int index){
        this.value=value;
        this.index=index;
    }
}

class StockSpanner {
    Stack<Pair> stack;
    int ind;
    
    public StockSpanner() {
        stack=new Stack<>();
        ind=-1;
    }
    
    public int next(int price) {
        int indices=prevGreater(price);
        indices=ind-indices;
        return indices;
    }
        
    public int prevGreater(int price) {
        ind++;
        int indices;
        while(!stack.isEmpty() && stack.peek().value<=price){
            stack.pop();
        }
        if(stack.isEmpty())
            indices=-1;
        else
            indices=stack.peek().index;
        stack.push(new Pair(price,ind));             
        
        return indices;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */