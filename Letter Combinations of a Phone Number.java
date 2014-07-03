public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] keypad = {{'0'}, {'1'}, {'a', 'b', 'c'}, 
                                  {'d', 'e', 'f'}, 
                                  {'g', 'h', 'i'}, 
                                  {'j', 'k', 'l'},
                                  {'m', 'n', 'o'},
                                  {'p', 'q', 'r', 's'},
                                  {'t', 'u', 'v'},
                                  {'w', 'x', 'y', 'z'}};
               
        List<String> results = new ArrayList <>();
        StringBuilder current = new StringBuilder();
        combination(digits, 0, current, results, keypad);
        
        return results;
    }
    
    private void combination(String digits, int s, StringBuilder cur, List<String> results, char [][] keypad) {
        if (s == digits.length()) {
            results.add(cur.toString());
            return;
        }
        
        int d = digits.charAt(s) - '0';
        for(char c: keypad[d]) {
            cur.append(c);
            combination(digits, s+1, cur, results, keypad);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
