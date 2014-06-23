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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack <TreeNode> stack = new Stack <> ();
        List <Integer> retList = new ArrayList <> ();
        
        TreeNode cur = root;
        while(cur != null) {
            stack.add (cur);
            cur = cur.left;
        }
        
        TreeNode last = null;
        while(!stack.empty()) {
            cur = stack.peek();
            if (cur.right != null && last != cur.right) {
                cur = cur.right;
                while(cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }
            } else {
                // no right child, or right child has just been visited
                cur = stack.pop();
                retList.add(cur.val);
                last = cur;
            }
        }
        
        return retList;
    }
}
