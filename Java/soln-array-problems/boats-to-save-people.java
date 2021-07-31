/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/boats-to-save-people
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {               
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int count=0;
        while(i<=j){
            if(people[i]+people[j]<=limit)
                i++;
            j--;
            count++;
        }
        return count;
    }
}
