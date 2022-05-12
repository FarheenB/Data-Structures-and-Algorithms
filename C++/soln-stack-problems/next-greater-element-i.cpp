/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-greater-element-i
*/

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map;       
        stack<int> st;
        vector<int> result(nums1.size());
        
        for(int i=nums2.size()-1;i>=0;i--){
            while(!st.empty() && st.top()<=nums2[i])               
                st.pop();
            
            if(st.empty())
                map[nums2[i]]=-1;
            else
                map[nums2[i]]=st.top();
            st.push(nums2[i]);
        }
        
        for(int i=0;i<nums1.size();i++)
            result[i]=map[nums1[i]];
        
        return result;
    }
};