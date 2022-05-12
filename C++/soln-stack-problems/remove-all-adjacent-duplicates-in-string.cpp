/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
*/

class Solution {
public:
    string removeDuplicates(string s) {
        stack<char> st;
        for(int i=0;i<s.length();i++) //traversing the stack
        {
            if(!st.empty() && st.top()==s[i]) 
                st.pop();
            
            else 
                st.push(s[i]);  
        }
        
        string str ="";
        while(!st.empty())
        {
            str.push_back(st.top());
            st.pop(); 
        }
        // as the stack reverses the order of elements we reverse str to get the final answer
        reverse(str.begin(),str.end()); 
        return str;
    }
};