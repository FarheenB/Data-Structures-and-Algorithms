/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-greater-element-ii/
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> result(nums.size());

        //for storing the indicies
        stack<int> st;
        
        for(int i=2*nums.size()-1;i>=0;i--){
            while(!st.empty() && nums[st.top()]<=nums[i%nums.size()]){
                st.pop();
            }
            if(st.empty())
                result[i%nums.size()]=-1;
            else
                result[i%nums.size()]=nums[st.top()];
            st.push(i%nums.size());             
        }
        return result;
    }
};