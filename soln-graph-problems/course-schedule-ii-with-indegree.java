/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/course-schedule-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> course_order=new ArrayList<>();
        int n=numCourses;
        ArrayList<Integer>[] adj_list=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();
        for(int edge[]:prerequisites)
            adj_list[edge[1]].add(edge[0]);
        
        indegree=new int[n];
        
        for(ArrayList<Integer> nodes:adj_list){
            for(int v:nodes)
                indegree[v]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        int order=0;
        while(!queue.isEmpty()){
            int node=queue.remove();
            course_order.add(node);
            order++;
            for(int adj_node:adj_list[node]){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    queue.add(adj_node);
            }
        }
        
        if(order!=n)
            return new int[0];
        
        int[] result=new int[course_order.size()];
        for(int i=0;i<course_order.size();i++){
            result[i]=course_order.get(i);
        }
        
        return result;
    }
}
