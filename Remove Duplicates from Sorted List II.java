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
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        boolean duplicate = false;
        ListNode left = head;
        ListNode right = head.next;
        ListNode newPos = dummy;
        
        while(right != null) {
            if (left.val == right.val) {
                duplicate = true;
                right = right.next;
            } else {
                if (duplicate) {
                    //igore all passed node
                    duplicate = false;
                } else {
                    newPos.next = left;
                    newPos = newPos.next;
                    
                }
                left = right;
                right = right.next;
            }
        }
        
        if (!duplicate) {
            newPos.next = left;
            newPos = newPos.next;
        }
        newPos.next = null;
        return dummy.next;
    }
}
