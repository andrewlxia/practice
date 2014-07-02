public class Solution {
    public String addBinary(String a, String b) {
        int ai = a.length()-1;
        int bi = b.length()-1;
        StringBuilder sumStr = new StringBuilder();
        
        int next = 0;
        while(ai >= 0 || bi >= 0) {
            int sum = next;
            if (ai >= 0) {
                sum += a.charAt(ai)-'0';
                ai --;
            }
            if (bi >= 0) {
                sum += b.charAt(bi)-'0';
                bi --;
            }
            sumStr.insert(0, (char)((sum%2)+'0'));
            next = sum/2;
        }
        
        if(next > 0) {
            sumStr.insert(0, '1');
        }
        
        return sumStr.toString();
    }
}
