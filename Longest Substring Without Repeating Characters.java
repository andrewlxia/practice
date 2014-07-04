public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //map a number to its index
        Map <Character, Integer> map = new HashMap <> ();
        
        int start = 0;
        int maxLen = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c) || start > map.get(c)) {
                maxLen = Math.max(maxLen, i-start+1);   
                
            } else {
                start = map.get(c)+1;
            }
            map.put(c, i);
        }
        
        return maxLen;
    }
}
