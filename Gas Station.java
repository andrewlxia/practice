public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diffs = new int[gas.length];
        
        for(int i=0; i<diffs.length; i++) {
            diffs[i] = gas[i] - cost[i];
        }
        
        int sum = 0;
        int totalLeft = 0;
        int start = 0;
        
        for(int i=0; i<diffs.length; i++) {
            totalLeft += diffs[i];
            sum += diffs[i];
            if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        
        if (totalLeft < 0) {
            return -1;
        }
        
        return start;
    }
}
