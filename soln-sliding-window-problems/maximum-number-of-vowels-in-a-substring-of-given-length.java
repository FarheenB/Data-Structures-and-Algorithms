/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
*/

class Solution {
    public int maxVowels(String s, int k) {
        int i=0;
        int j=0;
        int count=0;
        int max=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(isVowel(ch))
                count++;                    
            
            if(j-i+1==k){                
                max=Math.max(max,count);
                if(isVowel(s.charAt(i))){
                    count--;                        
                }                
                i++;
            }
            j++;
        }
        return max;
    }
    
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' ||  ch=='u')
            return true;
        return false;
    }
}
