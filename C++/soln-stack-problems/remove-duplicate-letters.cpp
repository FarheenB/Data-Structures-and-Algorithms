/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/remove-duplicate-letters
 https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
*/

class Solution {
public:
    string removeDuplicateLetters(string s) {
        unordered_map<char,int> map;
        for(char ch:s)
            map[ch]++;
        
        vector<bool> visited(26,false);
        stack<char> st;

        for(char ch:s){
            map[ch]--;
            
            if(visited[ch-'a']) 
                continue;
            
            while(!st.empty() && st.top()>ch && map[st.top()]>0){
                char removed=st.top();
                st.pop();    
                visited[removed-'a']=false;  
            }
            st.push(ch);
            visited[ch-'a']=true;
        }
        
        string ans="";
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};