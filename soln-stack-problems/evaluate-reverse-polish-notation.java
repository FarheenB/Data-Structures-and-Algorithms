/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/evaluate-expression/
 https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        HashSet<String> operators=new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        int res=0;
        
        for(String s:tokens){
            if(operators.contains(s))
            {
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                if(s.charAt(0)=='+'){

                    res=b+a;
                }
                else if(s.charAt(0)=='-'){
                    res=b-a;
                }
                else if(s.charAt(0)=='*'){
                    res=b*a;
                }
                else if(s.charAt(0)=='/'){
                    res=b/a;
                }
            }
            else{
                res=Integer.parseInt(s);
            }
            stack.push(res+"");
        }
        return Integer.parseInt(stack.pop());
    }
}   
