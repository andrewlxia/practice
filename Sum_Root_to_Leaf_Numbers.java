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
      return sumNumbersRecv(root, 0);
    }

    private int sumNumbersRecv(TreeNode root, int preVal) {
        if (root == null) {
            return 0;
        }
        
        int curVal = preVal*10 + root.val;
        if (root.left == null && root.right == null) {
            return curVal;
        }
        
        return sumNumbersRecv(root.left, curVal) + sumNumbersRecv(root.right, curVal);
    }
}
