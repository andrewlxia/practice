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
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumRecur(root);
        return maxSum;
    }
    
    private int maxPathSumRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = maxPathSumRecur(root.left);
        int rightSum = maxPathSumRecur(root.right);
        
        maxSum = Math.max(maxSum, leftSum+rightSum+root.val);
        
        return Math.max(0, Math.max(rightSum, leftSum)+root.val);
    }
}
