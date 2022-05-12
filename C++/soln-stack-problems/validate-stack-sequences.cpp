/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/validate-stack-sequences/
*/

class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> stack;     
        int index=0;
        
        for(int i=0;i<pushed.size();i++){
            stack.push(pushed[i]);
            while(!stack.empty() && popped[index]==stack.top() && index<popped.size()){
                stack.pop();
                index++;
            }                
        }
        return stack.empty()? true:false;        
    }
};