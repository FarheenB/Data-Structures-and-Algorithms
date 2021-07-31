/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/k-th-symbol-in-grammar/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1 && K==1)
            return 0;
        int mid=(int)((int)Math.pow(2,N-1)/2);
        if(K<=mid)
            return kthGrammar(N-1,K);
        return kthGrammar(N-1,K-mid)^1;
    }
}
