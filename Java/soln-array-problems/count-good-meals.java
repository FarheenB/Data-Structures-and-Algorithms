/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/count-good-meals
*/

class Solution {
    int mod = 1000000007;
    public int countPairs(int[] deliciousness) {
        long count=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - num)) {
                    count += map.get(power - num);
                    count %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int)count;
    }
}