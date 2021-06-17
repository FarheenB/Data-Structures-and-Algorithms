/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/random-pick-with-weight/
*/

class Solution {
    
    int[] cumm_weights;

    public Solution(int[] w) {
        for(int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }
        cumm_weights = w;
    }
    
    public int pickIndex() {
        int rand_int = ThreadLocalRandom.current().nextInt(1, cumm_weights[cumm_weights.length - 1] + 1);
        return binarySearch(rand_int, 0, cumm_weights.length - 1);
    }
    
    int binarySearch(int rand_int, int start, int end) {
        int mid = (start + end) / 2;
        int range_start = mid == 0 ? 1 : cumm_weights[mid - 1] + 1;
        int range_end = cumm_weights[mid];
        
        if(rand_int >= range_start && rand_int <= range_end) {
            return mid;
        }
        
        if(rand_int < range_start) {
            return binarySearch(rand_int, start, mid - 1);
        }
        
        return binarySearch(rand_int, mid + 1, end);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */