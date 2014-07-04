public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int [] num = new int[len+1];
        
        num[len] = 1;
        for(int i=len-1; i>=0; i--) {
            if(s.charAt(i) == '0') {
                num[i] = 0;
                continue;
            } 
            num[i] = num[i+1];
            if(i+2 <= s.length() && 
                (new Integer(s.substring(i, i+2))) <= 26) {
                num[i] += num[i+2];       
            }
        }
        
        return num[0];
    }
}
