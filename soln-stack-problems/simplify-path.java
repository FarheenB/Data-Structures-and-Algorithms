/*
https://leetcode.com/problems/simplify-path/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String simplifyPath(String path) {
        path=path+"/";
        Stack<String> stack=new Stack<>();
        int start=0;

        for(int i=1;i<path.length();i++){
            if(path.charAt(i)=='/'){
                int end=i;
                String str=path.substring(start+1,end);
                if(str.equals(".") || str.equals("")){
                    
                }
                else if(str.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else{
                    stack.push(str);
                }
                start=end;
            }
        }        

        StringBuilder newStr=new StringBuilder();

        for(String s:stack){
            newStr.append("/");
            newStr.append(s);
        }
        return newStr.length()>0?newStr.toString():"/";
    }
}