/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(0); //dummy node
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = p.next;
            p.next = temp;
        }
        
        return p.next;
    }
    
    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(0); //dummy node
        
        while(list1 != null && list2 != null) {
            p.next = list1;
            list1 = list1.next;
            p.next.next = list2;
            list2 = list2.next;
            p = p.next.next;
        }
        
        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }
        
        return p.next;
    }
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        ListNode rightHalf = reverseList(slow);
        
        head = mergeLists(head, rightHalf);
    }
}
