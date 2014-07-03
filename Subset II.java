public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Set<List<Integer>> results = new HashSet<List<Integer>> ();
        List<Integer> current = new ArrayList<Integer> ();
        Arrays.sort(num);
        
        subsetsRecur(num, 0, results, current);
        
        return new ArrayList(results);
    }
    
    private void subsetsRecur(int[] num, int idx, Set<List<Integer>> results, List<Integer> current) {
        if (idx == num.length) {
            results.add(new ArrayList<> (current));
            return;
        }
        
        subsetsRecur(num, idx+1, results, current);
        
        current.add(num[idx]);
        subsetsRecur(num, idx+1, results, current);
        current.remove(current.size()-1);
    }
}
