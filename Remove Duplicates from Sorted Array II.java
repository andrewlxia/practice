public class Solution {
    public int removeDuplicates(int[] A) {
       if (A == null || A.length == 0){
           return 0;
       }  
       
       int i=0, j=1;
       boolean first=true;
       while(j<A.length) {
           if(A[i] == A[j]) {
               if (first) {
                   A[++i] = A[j];
                   first=false;
               } 
               j++;
           } else {
               A[++i] = A[j];
               j++;
               first = true;
           }
       }
       
       return i+1;
    }
}
