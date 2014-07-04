public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        
        int size = triangle.size();
        int [][] sum = new int[size][size];
        
        for(int i=0; i<size; i++) {
            sum[size-1][i] = triangle.get(size-1).get(i);
        }
        
        for(int i=size-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        
        return sum[0][0];
    }
}
