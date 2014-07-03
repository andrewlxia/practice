public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || divisor == 1) {
            return dividend;
        }
        List<Integer> divisors = new ArrayList<> ();
        int divs = Math.abs(divisor);
        
        while(divs <= dividend) {
            divisors.add(divs);
            divs <<= 1;
        }
        
        int i = divisors.size()-1;
        int result = 0;
        int divd = Math.abs(dividend);
        while(i >= 0 && divd > 1) {
            divs = divisors.get(i);
            if (divd >= divs) {
                divd -= divs;
                result += 1<<i;
            }
            i--;
        }
        
        return result;
    }
}
