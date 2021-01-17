/*
https://www.geeksforgeeks.org/run-length-encoding/
https://leetcode.com/problems/string-compression/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int compress(char[] chars) {
        int i=0;
        int count=0;
        String output="";
        char alphabet=' ';
        for(int j=0;j<chars.length;j++)
        {
            if(chars[i]==chars[j])
            {
                alphabet=chars[i];
                count++;
            }
            else
            {
                i=j;
                j--;
                output=output+alphabet;
                if(count>1)
                    output=output+""+count;
                count=0;
            }
            
        }
        output=output+alphabet;
        if(count>1)
            output=output+""+count;
        
        int index=0;
        for(char s:output.toCharArray())
            chars[index++]=s;
        return index;
    }
}