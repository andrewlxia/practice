public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
    
        int y = x/10;
        int div = 1;
        while(y > 0) {
            div = div*10 + 0;
            y /= 10;
        }
        
        while(div > 0) {
            if (x/div != x%10) {
                return false;
            }
            x = (x%div)/10;
            div /= 100;
        }
        
        return true;
    }
}
