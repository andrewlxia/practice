public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> all_subsets = new ArrayList<List<Integer>> ();
        if(S.length == 0) {
            all_subsets.add(new ArrayList<Integer> ());
        }
        for (int i=0; i<(int)Math.pow(2.0, S.length); i++) {
            all_subsets.add(getSubset(S, i));
        }
        
        return all_subsets;
    }
    
    private List<Integer> getSubset(int[] S, int idx) {
        List<Integer> subset = new ArrayList<> ();
        
        for(int i=0; idx>0; i++) {
            if ((idx&0x1) == 0x1) {
                subset.add(S[i]);
            }
            idx >>= 1;
        }
        
        Collections.sort(subset);
        
        return subset;
    }
}


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> all_subsets = new ArrayList<List<Integer>> ();
        List<Integer> current = new ArrayList<Integer> ();
        Arrays.sort(S);
        
        subsetsRecur(S, 0, all_subsets, current);
        
        return all_subsets;
    }
    
    private void subsetsRecur(int[] S, int idx, List<List<Integer>> all_subsets, List<Integer> current) {
        if (idx == S.length) {
            all_subsets.add(new ArrayList<> (current));
            return;
        }
        
        subsetsRecur(S, idx+1, all_subsets, current);
        
        current.add(S[idx]);
        subsetsRecur(S, idx+1, all_subsets, current);
        current.remove(current.size()-1);
    }
}
