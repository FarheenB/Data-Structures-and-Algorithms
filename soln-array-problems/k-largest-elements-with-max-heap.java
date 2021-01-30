/*
https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i:arr){
            maxHeap.add(i);
        }
        
        int count=1;
        while(!maxHeap.isEmpty()){
            if(count>k)
                break;
            result.add(maxHeap.remove());
            count++;                
        }
        return result;
    }
}