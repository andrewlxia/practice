public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        Boolean complete [] = new Boolean [s.length()];
        Arrays.fill(complete, null);
        return wordBreakRecur(s, dict, 0, complete);
    }
    
    public boolean wordBreakRecur(String s, Set<String> dict, int start, Boolean [] complete){
        if (start >= s.length()) {
            return true;
        }
        
        if(complete[start] != null) {
            return complete[start];
        }
        
        for(int i=start; i<s.length(); i++) {
            if (dict.contains(s.substring(start, i+1)) &&
                wordBreakRecur(s, dict, i+1, complete)) {
                    complete[start] = true;
                    return true;
            }
        }
        
        complete[start] = false;
        return false;
    }
} 
