public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null) return (p == null);
        if (p.isEmpty()) return (s.isEmpty());
        
        // next char is not '*': do current char match?
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                    && isMatch(s.substring(1), p.substring(1));
        }
        
        // next char is '*'
        // current char match, zero or more repeats
        int i = 0;
        while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
            if (isMatch(s.substring(i), p.substring(2))) {
                return true;
            }
            i++;
        }
        
        // zero
        return isMatch(s.substring(i), p.substring(2));
    }
}
