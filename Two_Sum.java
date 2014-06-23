public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> valToIdx = new HashMap<> ();
        int ret[] = new int[] {-1, -1};
        
        for(int i=0; i<numbers.length; i++) {
            if (valToIdx.containsKey(target-numbers[i])) {
                ret[0] = valToIdx.get(target-numbers[i]);
                ret[1] = i+1;
                break;
            } 
            valToIdx.put(numbers[i], i+1);
        }
        
        return ret;
    }
}
