public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<> ();
        List<Integer> cur = new ArrayList <> ();
        Arrays.sort(candidates);
        
        helper(candidates, 0, target, cur, results);
        return results;
    }
    
    private void helper(int [] candidates, int s, int target, List<Integer> cur, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer> (cur));
            return;
        }
        if (s >= candidates.length || target < 0){
            return;
        }
        
        for(int i=s; i<candidates.length && candidates[s] <= target; i++) {
            cur.add(candidates[i]);
            helper(candidates, i, target-candidates[i], cur, results);
            cur.remove(cur.size()-1);
        }
    }
}
