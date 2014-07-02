/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    private ListNode curPos;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.curPos = head;  
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return createBSTFromList(0, len-1);
    }
    
    private TreeNode createBSTFromList(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        
        TreeNode left = createBSTFromList(start, mid-1);
        TreeNode root = new TreeNode(curPos.val);
        this.curPos = this.curPos.next;
        root.left = left;
        root.right = createBSTFromList(mid+1, end);
        
        return root;
    }
}
