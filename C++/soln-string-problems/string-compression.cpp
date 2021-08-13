/**
 @author Farheen Bano
  
 Date 11-08-2021

 Reference-
 https://leetcode.com/problems/string-compression
*/

class Solution {
public:
    int compress(vector<char>& chars) {
        int i=0;
        int index=0;
        while(i<chars.size()){
            int j=i;
            while(j<chars.size() && chars[i]==chars[j])
                j++;
            
            chars[index++]=chars[i];
            if(j-i>1){
                string count=to_string(j-i);
                for(char ch:count)
                    chars[index++]=ch;
            }
            i=j;
        }
        return index;
    }
};