public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int [][] paths = new int[m][2];
        
        for(int i=0; i<m; i++) {
            paths[i][0] = 1;
        }
        int row = 0;
        for(int j=1; j<n; j++) {
            row = 1-row;
            paths[0][row] = 1;
            for (int i=1; i<m; i++) {
                paths[i][row] = paths[i][1-row] + paths[i-1][row];
            }
        }
        
        return paths[m-1][(n-1)%2];
    }
}
