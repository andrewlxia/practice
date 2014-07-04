public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0, start = -1;
        Stack <Integer> lefts = new Stack ();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if(lefts.isEmpty()) {
                    start = i;
                } else {
                    lefts.pop();
                    int curLen = 0;
                    if(lefts.isEmpty()) {
                        curLen = i-start;
                    } else{
                        curLen = i-lefts.peek();
                    }
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }
        
        return maxLen;
    }
}
