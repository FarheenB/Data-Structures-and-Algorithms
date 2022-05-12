/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/evaluate-expression/
 https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/

class Solution {
public:
    bool isOperator(string c){
        if(c=="+"||c=="-"||c=="/"||c=="*")
            return true;
        return false;
    }
    
    int evalRPN(vector<string>& tokens) {
        stack<int>st;
        int n = tokens.size();
        for(string token:tokens){
            if(!isOperator(token)){
                st.push(stoi(token));
            }
            else{
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                if(token=="+"){
                    st.push(b+a);
                }
                else if(token=="-"){
                    st.push(b-a);
                }
                else if(token=="/"){
                    st.push(b/a);
                }
                else{
                    st.push(b*a);
                }
            }
        }
        return st.top();
    }
};