/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int solve(ArrayList<Integer> A) {
        if(A==null){
            return 0;
        }
        return Collections.max(A)+Collections.min(A);
    }
}
