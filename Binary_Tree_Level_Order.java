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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <>();
        List<List<Integer>> results = new ArrayList <> ();
        List<Integer> level = new ArrayList<> ();
        
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                results.add(level);
                if (!queue.isEmpty()) {
                    level = new ArrayList <> ();
                    queue.add(null);
                }
            } else {
                level.add(n.val);
                if(n.left != null) {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        
        return results;
    }
}
