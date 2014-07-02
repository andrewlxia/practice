public class Solution {
    public int maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int a: A) {
            sum += a;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        
        return maxSum;
    }
}
