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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedListEmptyHead = new ListNode();
        ListNode mergedListLastNode = mergedListEmptyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergedListLastNode.next = list1;
                mergedListLastNode = list1;
                list1 = list1.next;
            } else {
                mergedListLastNode.next = list2;
                mergedListLastNode = list2;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            mergedListLastNode.next = list2;
        } else {
            mergedListLastNode.next = list1;
        }

        return mergedListEmptyHead.next;
    }
}