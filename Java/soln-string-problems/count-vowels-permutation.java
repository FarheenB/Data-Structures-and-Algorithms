/**
 @author Farheen Bano
  
 Date 15-07-2021
 
 Reference-
 https://leetcode.com/problems/count-vowels-permutation/
*/

class Solution {
    int mod = 1000000007;

    public int countVowelPermutation(int n) {
        long sum = 0;
        long[] v = new long[]{1, 1, 1, 1, 1}; //a-0, e-1, i-2, o-3, u-4
        for (long i : iterate(v, n - 1)) 
            sum = (sum + i) % mod;
        return (int) sum;
    }
    
    public long[] iterate(long[] v, int n) {
        if (n == 0) return v;
        long[] v1 = new long[5];
        v1[0] = (v[1] + v[2] + v[4]) % mod;
        v1[1] = (v[0] + v[2]) % mod;
        v1[2] = (v[1] + v[3]) % mod;
        v1[3] = v[2];
        v1[4] = (v[2] + v[3]) % mod;
        return iterate(v1, n - 1);
    }
}