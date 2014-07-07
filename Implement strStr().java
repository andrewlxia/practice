public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null 
            || (haystack.isEmpty() && ! needle.isEmpty())) {
                return null;
        }
        if (needle.isEmpty()) {
            return haystack;
        }
        
        int [] failarr = new int[needle.length()+1];
        buildFailArray(failarr, needle);
        
        
        int offset = 0;
        int nstart = 0;
        while(offset<haystack.length()) {
           if(haystack.charAt(offset) == needle.charAt(nstart)) {
                nstart++;
                offset++;
                if (nstart == needle.length()) {
                    return haystack.substring(offset-nstart); 
                } 
           } else if (nstart > 0) {
               nstart = failarr[nstart];
           } else {
               offset++;
           }
        }
        
        return null;
    }
    
    private void buildFailArray(int arr [], String p) {
        arr[0] = -1;
        for(int i=2; i<p.length(); i++) {
            int k = arr [i-1];
            while(k>-1 && p.charAt(k) != p.charAt(i-1)) {
                k = arr[k];
            }
            if (k > -1) {
                arr[i] = k+1;
            }
        }
    }
}
