/**
 @author Farheen Bano
  
 Reference-
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
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i:arr){
            minHeap.add(i);
            if(minHeap.size()>k) {
                minHeap.remove();
            }
        }
        
        while(!minHeap.isEmpty()){
            result.add(minHeap.remove());
        }
        Collections.reverse(result);
        return result;
    }
}
