public class Solution {
    public int minPathSum(int[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        
        int [][] pathSum = new int[len1][2];
        
        pathSum[0][0] = grid[0][0];
        int row = 0;
        for(int i=1; i<len1; i++) {
            pathSum[i][0] = pathSum[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i<len2; i++) {
            row = 1-row;
            pathSum[0][row] = pathSum[0][1-row] + grid[0][i]; 
            for (int j=1; j<len1; j++) {
                pathSum[j][row] = Math.min(pathSum[j-1][row], pathSum[j][1-row]) + grid[j][i];
            }
        }
        
        return pathSum[len1-1][(len2-1)%2];
    }
}
