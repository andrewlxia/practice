public class Solution {
    public List<String> anagrams(String[] strs) {
        Map <String, List<String>> anagramMap = new HashMap <> ();
        
        for(String s: strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            List <String> anagramGroup = anagramMap.get(sorted);
            if (anagramGroup == null) {
                anagramGroup = new ArrayList <String> ();
                anagramMap.put(sorted, anagramGroup);
            }
            anagramGroup.add(s);
        }
        
        List <String> ret = new ArrayList<> ();
        for(List <String> l: anagramMap.values()) {
            if (l.size() > 1) {
                ret.addAll(l);
            }
        }
        
        return ret;
    }
}
