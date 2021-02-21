/*
https://leetcode.com/problems/add-strings/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder str=new StringBuilder();
        int carry=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        while(i>=0 || j>=0){
            int add=carry;
            if(i>=0){
                add+=(num1.charAt(i)-'0');
                i--;
            }
            if(j>=0){
                add+=(num2.charAt(j)-'0');
                j--;
            }
            str.append(add%10);            
            carry=add/10;
        }
        if(carry!=0)
            str.append(carry);            
    
        return str.reverse().toString();
    }
}