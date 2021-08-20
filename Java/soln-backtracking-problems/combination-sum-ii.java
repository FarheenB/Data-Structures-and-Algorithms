/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> subsets=new ArrayList<>();
        generateSubsets(0,candidates, new ArrayList<Integer>(),subsets,target);
        return subsets;
        
    }
    
    public void generateSubsets(int index, int[] candidates, List<Integer> cur, List<List<Integer>> subsets, int target){
        if(target==0) {
            subsets.add(new ArrayList<>(cur));
            return;
        }
        
        if(target<0)
            return;
        
        for(int i=index;i<candidates.length;i++) {
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            
            cur.add(candidates[i]);
            generateSubsets(i+1,candidates,cur,subsets,target-candidates[i]);
            cur.remove(cur.size()-1);
        }
    }
}