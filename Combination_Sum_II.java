public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<> ();
        List<Integer> cur = new ArrayList <> ();
        Arrays.sort(num);
        
        helper(num, 0, target, cur, results);
        return results;
    }
    
    private void helper(int [] num, int s, int target, List<Integer> cur, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer> (cur));
            return;
        }
        if (s >= num.length || target < 0){
            return;
        }
        
        for(int i=s; i<num.length && num[s] <= target; i++) {
            if(i>s && num[i] == num[i-1]) {
                continue;
            }
            cur.add(num[i]);
            helper(num, i+1, target-num[i], cur, results);
            cur.remove(cur.size()-1);
        }
    }
}
