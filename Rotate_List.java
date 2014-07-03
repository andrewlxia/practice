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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n <= 0) {
            return head;
        }
        
        ListNode left = head;
        ListNode right = head;
        while(n > 0 || right.next != head) {
            if (n > 0) {
                n--;
            } else {
                left = left.next;
            }
            if(right.next == null) {
                right.next = head;
            }
            right = right.next;
        }
        
        ListNode newHead = left.next;
        left.next = null;
        
        return newHead;
    }
}
