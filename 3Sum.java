public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Set<List<Integer>> set = new HashSet<> ();
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++) {
            int j=i+1, k=num.length-1;
            while(j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    List<Integer> triple = new ArrayList<> ();
                    triple.add(num[i]);
                    triple.add(num[j]);
                    triple.add(num[k]);
                    set.add(triple);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return new ArrayList(set);
    }
}
