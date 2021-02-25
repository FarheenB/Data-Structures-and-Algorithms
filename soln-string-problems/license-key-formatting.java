/*
https://leetcode.com/problems/license-key-formatting
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder str=new StringBuilder();
        int count=0;
        
        for(int i=S.length()-1;i>=0;i--){
            char ch=S.charAt(i);
            if(ch=='-')
                continue;
            else if(Character.isDigit(ch))
                str.append(ch);
            else
                str.append(Character.toUpperCase(ch));
            
            count++;
            if(count==K){
                str.append("-");
                count=0;
            }
        }
        if(str.length()>0 && str.charAt(str.length()-1)=='-')
           str.deleteCharAt(str.length()-1);
        return str.reverse().toString();
    }
}