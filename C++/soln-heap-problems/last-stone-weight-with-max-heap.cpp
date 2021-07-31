/**
 @author Farheen Bano
  
 Date 19-07-2021

 Reference-
 https://leetcode.com/problems/last-stone-weight
*/

class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int, vector<int>> maxHeap;
        
        for(int stone:stones){
            maxHeap.push(stone);
        }
        
        while(maxHeap.size()>1){
            int y=maxHeap.top();
            maxHeap.pop();
            int x=maxHeap.top();
            maxHeap.pop();
            if(x!=y){
                y=y-x;
                maxHeap.push(y);
            }    
   
        }
        return maxHeap.empty()?0:maxHeap.top();
    }
}; 