/*
https://leetcode.com/problems/unique-email-addresses
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set=new HashSet<>();
        for(String email:emails){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<email.length();i++){
                if(email.charAt(i)=='.')
                    continue;
                if(email.charAt(i)=='+'){
                    int rate_indx=email.indexOf('@');
                    str.append(email.substring(rate_indx));
                    break;
                }
                if(email.charAt(i)=='@'){
                    str.append(email.substring(i));
                    break;
                }
                else
                    str.append(email.charAt(i));
            }          
            set.add(str.toString());
        }
        return set.size();
    }
}