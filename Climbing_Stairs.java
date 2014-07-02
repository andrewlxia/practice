public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int results[] = {1,1,0};
        int cur = 2;
        
        while(cur <= n) {
            results[cur%3] = results[(cur-1)%3] + results[(cur-2)%3];
            cur ++;
        }
        
        return results[n%3];
    }
}
