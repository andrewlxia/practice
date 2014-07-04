public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int n = s.length();
        int maxLen = 0;
        int start = -1;
        
        boolean [][] sub = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            sub[i][i] = true;
        }
        for(int i=0; i<n-1; i++) {
            sub[i][i+1] = (s.charAt(i)==s.charAt(i+1));
            if(sub[i][i+1] && maxLen < 2) {
                maxLen = 2;
                start = i;
            }
        }
        for(int len=3; len<=n; len++){
            for(int i=0; i<n-len+1; i++) {
                int j = i+len-1;
                sub[i][j] = sub[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                if (sub[i][j] && maxLen < len) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        
        
        return s.substring(start, start+maxLen);
    }
}
