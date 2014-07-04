public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList <> ();
        StringBuilder sb = new StringBuilder();
        generator(n, 0, 0, sb, results);
        
        return results;
    }
    
    private void generator(int n, int l, int r, StringBuilder cur, List<String> results) {
        if (l==n) {
            while(r++ < n) {
                cur.append(')');
            }
            results.add(cur.toString());
        } else if (l==r) {
            cur.append('(');
            generator(n, l+1, r, cur, results);
        } else { //l > r ( l can neve be smaller than r)
            int oldLen = cur.length();
            cur.append('(');
            generator(n, l+1, r, cur, results);
            cur.delete(oldLen, cur.length());
            cur.append(')');
            generator(n, l, r+1, cur, results);
        }            
    }
}
