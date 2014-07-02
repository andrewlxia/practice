public class Solution {
    private class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        Map <Integer, List<pair>> pairsMap = new HashMap<> ();
        Set<List<Integer>> results = new HashSet<>();
        
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                int sum = num[i] + num[j];
                List<pair> pairs = pairsMap.get(sum);
                if (pairs == null) {
                    pairs = new ArrayList<> ();
                    pairsMap.put(sum, pairs);
                }
                pairs.add(new pair(i, j));
                
                pairs = pairsMap.get(target-sum);
                if (pairs == null) {
                    continue;
                }
                for(pair p: pairsMap.get(target-sum)) {
                    if(p.x != i && p.x != j && p.y != i && p.y != j) {
                        List <Integer> l = new ArrayList();
                        l.add(num[i]);
                        l.add(num[j]);
                        l.add(num[p.x]);
                        l.add(num[p.y]);
                        Collections.sort(l);
                        results.add(l);
                    }
                }
            }
        }
        
        return new ArrayList(results);
    }
}
