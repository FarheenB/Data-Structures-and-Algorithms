/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Item{
    int val;
    int index;
    
    public Item(int val, int index){
        this.val=val;
        this.index=index;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Item items[]=new Item[nums.length];
        for(int i=0;i<nums.length;i++){
            items[i]=new Item(nums[i],i);
        }
        
        int count[]=new int[nums.length];
        mergesort(items,0,items.length-1,count);
        
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<count.length;i++){
            result.add(count[i]);
        }
        return result;
    }
    
    private void mergesort(Item items[], int low, int high, int count[]){
        if(low>=high)
            return;
        int mid=low+(high-low)/2;
        mergesort(items,low,mid,count);
        mergesort(items,mid+1,high,count);
        merge(items, low, mid, mid+1, high, count);
    }
    
    private void merge(Item[] items, int low, int lowEnd, int high, int highEnd, int count[]){
        int len=highEnd-low+1;
        
        Item[] sortedArr=new Item[len];
        
        int lowPtr=low;
        int highPtr=high;
        int index=0;
        int rightCount=0;
        
        while(lowPtr<=lowEnd && highPtr<=highEnd){            
            if(items[highPtr].val<items[lowPtr].val){
                rightCount++;
                sortedArr[index++]=items[highPtr++];
            }
            else{
                count[items[lowPtr].index]+=rightCount;
                sortedArr[index++]=items[lowPtr++];
            }
        }
        
        while(lowPtr<=lowEnd){
            count[items[lowPtr].index]+=rightCount;
            sortedArr[index++]=items[lowPtr++];
        }
        while(highPtr<=highEnd){
            sortedArr[index++]=items[highPtr++];
        }
        
        System.arraycopy(sortedArr, 0, items, low, len);
    }
}
