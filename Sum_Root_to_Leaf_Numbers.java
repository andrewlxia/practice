/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
      if (root == null) 
        return 0;
        
      return sumNumbersRecv(root, 0);
    }

    private int sumNumbersRecv(TreeNode root, int preVal) {
        assert (root != null);
        
        int curVal = preVal*10 + root.val;
        if (root.left == null && root.right == null) {
            return curVal;
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += sumNumbersRecv(root.left, curVal);
        }
        if (root.right != null) {
            sum += sumNumbersRecv(root.right, curVal);
        }
        
        return sum;
    }
}
