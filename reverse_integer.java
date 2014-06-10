public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        int ret = 0;
        while(x>0) {
            ret = ret*10 + x%10;
            x /= 10;
        }
        
        if (negative) {
            ret = -ret;
        }
         
        return ret;
    }
}
