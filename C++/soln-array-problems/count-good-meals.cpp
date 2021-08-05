/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/count-good-meals
*/

class Solution {
public:
    int mod = 1000000007;
    int countPairs(vector<int>& deliciousness) {
        long count=0;
        unordered_map<int, int> map;
        for (int num : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.find(power - num)!=map.end()) {
                    count += map[power - num];
                    count %= mod;
                }
                power *= 2;
            }
            map[num]=map[num]+1;
        }
        return (int)count;
    }
};