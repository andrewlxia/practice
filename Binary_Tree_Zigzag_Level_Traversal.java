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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList <> ();
        Stack<TreeNode> stack = new Stack<> ();
        
        if (root != null) {
            stack.push(root);
        }
        boolean evenLevel = true;
        while(!stack.isEmpty()) {
            List<Integer> level = new ArrayList <> ();
            Stack<TreeNode> stackTemp = new Stack <> ();
            while(!stack.isEmpty()) {
                TreeNode n = stack.pop();
                level.add(n.val);
                if(evenLevel) {
                    if (n.left != null) {
                        stackTemp.push(n.left);
                    }
                    if (n.right != null) {
                        stackTemp.push(n.right);
                    }
                } else {
                    if (n.right != null) {
                        stackTemp.push(n.right);
                    }
                    if (n.left != null) {
                        stackTemp.push(n.left);
                    }
                }
            }
            results.add(level);
            stack = stackTemp;
            evenLevel = !evenLevel;
        }
        
        return results;
    }
}
