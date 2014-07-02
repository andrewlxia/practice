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
    public int minDepth(TreeNode root) {
        return minDepthRecur(root);
    }
    
    private int minDepthRecur(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = minDepthRecur(root.left);
        int right = minDepthRecur(root.right);
        if (left == 0) {
            return right+1;
        } 
        if (right == 0) {
            return left+1;
        } 
        return Math.min(left, right) + 1;
    }
}
