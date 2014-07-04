public class Solution {
    public int sqrt(int x) {
        if (x < 2) {
            return x;
        }
        int s = 0;
        int e = x;
        while(e-s > 1) {
            int mid = (s+e)/2;
            int div = x/mid;
            if (div == mid) {
                return mid;
            } else if (div < mid) {
                e = mid;
            } else {
                s = mid;
            }
        }
        
        return s;
    }
}
