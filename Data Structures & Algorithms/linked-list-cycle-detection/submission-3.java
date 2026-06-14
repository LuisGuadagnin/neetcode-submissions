/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while(fastNode != null) {
            if (slowNode == fastNode) {
                return true;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next == null 
                    ? fastNode.next
                    : fastNode.next.next;
        }
        return false;
    }
}
