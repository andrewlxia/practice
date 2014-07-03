public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i=0; i<A.length; i++) {
            while(A[i] > 0 && A[i] <= A.length && 
                A[i] != i+1 && A[i] != A[A[i]-1]) {
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
            }
        }
        
        int i=0;
        while(i<A.length && A[i] == i+1){
            i++;
        }
        
        return i+1;
    }
}
