public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            //verify each vertical line and horizontal line
            Set <Character> vertical = new HashSet <> ();
            Set <Character> horizontal = new HashSet <> ();
            for(int j=0; j<9; j++) {
                if(!verifyGroup(board[i][j], horizontal)) {
                    return false;
                }
                if(!verifyGroup(board[j][i], vertical)) {
                    return false;
                }
            }
        }
        
        for(int i=0; i<9; i+=3) {
            
        }
        
        
    }
    
    private boolean verifyGroup(char c, Set <Character> group) {
        if (c == '.') {
            return true;
        }
        
        if(c > '9' || c < '0' || horizontal.contains(c)) {
            return false;
        }
        group.add(c);
        return true;
    }
}
