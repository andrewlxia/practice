/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode left=head;
        ListNode right=head.next;
        
        while(right != null) {
            if(right.val == left.val) {
                left.next = right.next;
                right.next = null;
                right = left.next;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        
        return head;
    }
}
