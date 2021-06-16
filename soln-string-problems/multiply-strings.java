/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/multiply-strings/
 https://leetcode.com/problems/multiply-strings/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String multiply(String num1, String num2) {
        int product[]=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=product[i+j+1]+mul;
                product[i+j+1]=sum%10;
                product[i+j]+=sum/10;
            }
        }
        StringBuilder str=new StringBuilder();
        for(int n:product){
            if(str.length()!=0 || n!=0)
                str.append(n);
        }
        return str.length()==0?"0":str.toString();
    }
}
