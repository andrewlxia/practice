public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<StringBuilder> result = wordBreakRecur(s, dict, 0);
        List<String> ret = new ArrayList<> ();
        
        if (result != null) {
            for(StringBuilder words: result) {
                ret.add(words.toString());
            }
        }
        
        return ret;
    }
    
    private List<StringBuilder> wordBreakRecur(String s, Set<String> dict, int start){
        List<StringBuilder> ret = new ArrayList<> ();
        if (start == s.length()) {
            ret.add(new StringBuilder());
            return ret;
        }
        
        for(int i=start; i<s.length(); i++) {
            String word = s.substring(start, i+1);
            if (dict.contains(word)){
                List<StringBuilder> wordsList = wordBreakRecur(s, dict, i+1);
                if (wordsList != null) {
                    for(StringBuilder subWords: wordsList) {
                        subWords.insert(0, word + ' ');
                        ret.add(subWords);
                    }
                }
            }
        }
        
        if(ret.size() > 0) {
            return ret;
        }
        
        return null;
    }
}
