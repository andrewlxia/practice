public class Solution {
    public String reverseWords(String s) {
        String words [] = s.trim().split("\\s+");
        
        StringBuilder retStr = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            if(!words[i].isEmpty()) {
                retStr.append(words[i]);
                retStr.append(" ");
            }
        }
        
        return retStr.toString().trim();
    }
}
