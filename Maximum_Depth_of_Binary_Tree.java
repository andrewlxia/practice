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
    public int maxDepth(TreeNode root) {
        return maxDepthRecur(root);
    }
    
    private int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right)) + 1;
    }
}
