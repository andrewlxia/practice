public class Solution {
    public int numDistinct(String S, String T) {
        if(S == null || S.isEmpty() || T == null || T.isEmpty()) {
            return 0;
        }
        
        int slen = S.length();
        int tlen = T.length();
        
        int [][] sum = new int[slen][tlen];
        
        sum[slen-1][tlen-1] = (S.charAt(slen-1)==T.charAt(tlen-1))?1:0;
        for(int i=slen-2; i>=0; i--) {
            sum[i][tlen-1] = sum[i+1][tlen-1] + ((S.charAt(i)==T.charAt(tlen-1))?1:0);
        }
        
        for(int i=slen-2; i>=0; i--) {
            for(int j=tlen-2; j>=0; j--) {
                sum[i][j] = sum[i+1][j];
                if(S.charAt(i) == T.charAt(j)) {
                    sum[i][j] += sum[i+1][j+1];
                }
            }
        }
        
        return sum[0][0];
    }
}
