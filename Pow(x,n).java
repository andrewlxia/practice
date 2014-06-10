public class Solution {
    public double pow(double x, int n) {
        if (n < 0) {
            return 1/powRecur(x, -n);
        }
        
        return powRecur(x, n);
    }
    
    public double powRecur(double x, int n) {
        if (n==1) 
            return x;
        if (n==0)
            return 1;
            
        double half = pow(x, n/2);
        double ret = half*half;
        if (n%2 == 1) {
            ret *= x;
        }
        
        return ret;
    }
}
