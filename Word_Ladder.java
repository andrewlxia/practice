public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue <String> queue = new LinkedList <> ();
        Set <String> visited = new HashSet<> ();
        int len = 1;
        
        queue.add(start);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur == null) {
                len++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            
            if (cur.equals(end)) {
                return len;
            }
            if (!visited.contains(cur)) {
                visited.add(cur);
                    
                for(int i=0; i<cur.length(); i++) {
                    StringBuilder next = new StringBuilder(cur);
                    for (char j='a'; j<='z'; j++) {
                        if (j == cur.charAt(i)) continue;
                        next.setCharAt(i, j);
                        String nextWord = next.toString();
                        if (dict.contains(nextWord)) {
                            queue.add(nextWord);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
