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

    /*
    [0, 1, 2, 3, 4, 5, 6]
    n = 2

    i -> 0 / toRemove -> null
    i -> 1 / toRemove -> null
    i -> 2 / toRemove -> 0
    ...
    i -> 6 / toRemove -> 4
    
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode nthFromEnd = null;
        ListNode previousNthFromEnd = null;
        ListNode curr = head;
        while(curr != null) {
            if (i + 1 == n) {
                nthFromEnd = head;
            } else if (i + 1 > n) {
                previousNthFromEnd = nthFromEnd;
                nthFromEnd = nthFromEnd.next;
            }

            i++;
            curr = curr.next;
        }
        if (nthFromEnd == head) {
            return head.next; // remove the head
        }
        if (nthFromEnd != null) {
            previousNthFromEnd.next = nthFromEnd.next;
        }
        return head;
    }
}
