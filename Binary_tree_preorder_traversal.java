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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack <TreeNode> stack = new Stack <> ();
        List <Integer> retList = new ArrayList<> ();
        
        TreeNode cur = root;
        while(cur != null) {
            retList.add(cur.val);
            stack.push(cur);
            cur = cur.left;
        }
        
        while(!stack.empty()) {
            cur = stack.pop();
            cur = cur.right;
            while (cur != null) {
                retList.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        return retList;
    }
}
