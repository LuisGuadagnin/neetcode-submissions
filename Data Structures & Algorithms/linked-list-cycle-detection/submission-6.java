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
        while (head != null) {
            if (head.val == -1001) {
                return true;
            }
            head.val = -1001;
            head = head.next;
        }
        return false;

        /*
        if (head == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
        */
    }
}
