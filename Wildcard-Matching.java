public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchRecur(s, 0, p, 0);
    }
    
    private boolean isMatchRecur(String s, int sstart, String p, int pstart) {
        if(sstart == s.length() || pstart == p.length()) {
            if(sstart == s.length() && pstart == p.length()) {
                return true;
            } else {
                return false;
            }
        }
        
        char sc = s.charAt(sstart);
        char pc = p.charAt(pstart);
        if(pc == '?' || sc == pc) {
            return isMatchRecur(s, sstart+1, p, pstart+1);
        } else if(pc == '*') {
            while(pstart < p.length()-1 && p.charAt(pstart) == '*') {
                pstart ++;
            }
            while(sstart++ < s.length()) {
                if(isMatchRecur(s, sstart, p, pstart)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
