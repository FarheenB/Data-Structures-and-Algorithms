/*
 @author Farheen Bano

 References- 
 https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 https://leetcode.com/problems/decode-ways/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;

        int []dp= new int [s.length()+1];

        dp[0]=1;
        dp[1]= (s.charAt(0)!='0')?1:0;

        for(int i=2;i<=s.length();i++) {
            int oneDigit= Integer.parseInt(s.substring(i-1,i)); 
            int twoDigit= Integer.parseInt(s.substring(i-2,i));

            if(oneDigit>=1)
                dp[i]+=dp[i-1]; 

            if(twoDigit>=10 && twoDigit<=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
}
