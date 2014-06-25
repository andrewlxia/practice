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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack <TreeNode> stack = new Stack <> ();
        List <Integer> ret = new ArrayList <> ();
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        return ret;
    }
}
