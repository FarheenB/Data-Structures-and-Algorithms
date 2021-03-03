/*
https://leetcode.com/problems/course-schedule-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int[] visited;
    HashSet<Integer>[] adj_list;
    ArrayList<Integer> order=new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0){
            int[] result=new int[numCourses];
            for(int i=0;i<numCourses;i++)
                result[i]=i;
            return result;
        }
        
        visited=new int[numCourses];    
        adj_list=new HashSet[numCourses];
        
        for(int i=0;i<numCourses;i++)
            adj_list[i]=new HashSet<>();
        for(int pre[]:prerequisites){
            adj_list[pre[0]].add(pre[1]);
        }
        
        if(!isValidPrerequisites(numCourses)){
            return new int[0];   
        }   
        
        int[] result=new int[order.size()];
        for(int i=0;i<order.size();i++){
            result[i]=order.get(i);
        }
        
        return result;
    }
        
        
    public boolean isValidPrerequisites(int numCourses){
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && !dfs(i))
                return false;                 
        }
        return true;
    }
    
    public boolean dfs(int course){   
        if(visited[course]==2){
            return true;            
        }
        
        visited[course]=1;
        for(int c:adj_list[course]){
            if(visited[c]==1 || !dfs(c))
                return false;         
        }        
        visited[course]=2;
        order.add(course);

        return true;
    }   
}

               