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
    public TreeNode sortedArrayToBST(int[] num) {
        return createBST(num, 0, num.length-1);
    }
    
    private TreeNode createBST(int [] num, int start, int end) {
        if (start>end) {
            return null;
        }
        int mid = (start+end)/2;
        
        TreeNode node = new TreeNode(num[mid]);
        node.left = createBST(num, start, mid-1);
        node.right = createBST(num, mid+1, end);
        
        return node;
    }
}
