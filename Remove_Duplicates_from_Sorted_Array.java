public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int i=0, j=1;
        while(j<A.length) {
            if (A[i] == A[j]) {
                j ++;
            } else {
                if (i+1 != j) {
                    A[i+1] = A[j];
                }
                i++;
                j++;
            }
        }
        
        return i+1;
    }
}
