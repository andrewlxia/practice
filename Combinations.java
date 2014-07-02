public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<> ();
        List<Integer> curCom = new ArrayList<>();
        combineRecur(n, 1, k, curCom, combinations);
        
        return combinations;
    }
    
    private void combineRecur(int n, int start, int num, List<Integer> comb, List<List<Integer>> allCom) {
        if (num == 0) {
            allCom.add(new ArrayList<Integer>(comb));
            return;
        }
        if (start > n) {
            return;
        }
        
        comb.add(start);
        combineRecur(n, start+1, num-1, comb, allCom);
        comb.remove(comb.size()-1);
        combineRecur(n, start+1, num, comb, allCom);
    }
}
