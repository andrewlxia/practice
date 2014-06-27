/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        if (p == null) {
            return null;
        }
        
        // make copies and chain them interleavely with original node
        while(p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            temp.random = p.random;
            p.next = temp;
            p = p.next.next;
        }
        
        //update random pointer of new nodes
        p = head;
        while(p != null) {
            p = p.next;
            if(p.random != null) { 
                p.random = p.random.next;
            }
            p = p.next;
        }
        
        // split to two lists
        p = head;
        RandomListNode newList = p.next;
        RandomListNode q;
        while(p != null) {
            q = p.next;
            p.next = q.next;
            p = p.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
        }
        
        return newList;
    }
}
