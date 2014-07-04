public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0] == elem?0:1;
        }
        
        int l = 0;
        int r = A.length-1;
        int left = A.length;
        
        while(l<=r) {
            while (l<A.length && A[l] != elem) {
                l++;
            };
            while (r>=0 && A[r] == elem) {
                r--;
                left--;
            };
            if (l<r && A[l] == elem)  {
                A[l] = A[r];
                left --;
                r--;
            }
        }
        
        return left;
    }
}
