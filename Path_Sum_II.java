public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> validPaths = new ArrayList<List<Integer>> ();
        List<Integer> curPath = new ArrayList<Integer> ();
        
        pathSumRecur(root, sum, validPaths, curPath);
        
        return validPaths;
    }
    
    private void pathSumRecur(TreeNode root, int sum, List<List<Integer>> validPaths, List<Integer> curPath) {
        if (root == null) {
            return;
        }
        
        curPath.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            validPaths.add(new ArrayList<Integer>(curPath));  //make sure saving a copy, since the list will be changed
        } else {
            pathSumRecur(root.left, sum-root.val, validPaths, curPath);
            pathSumRecur(root.right, sum-root.val, validPaths, curPath);
        }
        curPath.remove(curPath.size()-1);
    }
}
