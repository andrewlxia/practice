public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        int idx = 0;
        while(idx < strs[0].length()) {
            char c = strs[0].charAt(idx);
            for (int i=1; i<strs.length; i++) {
                if(idx >= strs[i].length() || strs[i].charAt(idx) != c) {
                    return strs[0].substring(0, idx);
                }
            }
            idx ++;
        }
        
        return strs[0];
    }
}
