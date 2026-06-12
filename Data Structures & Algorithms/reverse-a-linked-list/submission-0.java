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

/*
1 > 2 > 3 > 4
ordered = 1

2 > 3 > 4
ordered = 2
1
reversed = 1

3 > 4
ordered = 3
2 > 1
reversed = 2
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode ordered = head;
        ListNode reversed = null;
        
        while(ordered != null) {
            ListNode moving = ordered;
            ordered = ordered.next;
            moving.next = reversed;
            reversed = moving;
        }

        return reversed;
    }
}
