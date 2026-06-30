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
            int valList1 = list1.val;
            int valList2 = list2.val;

            if (valList1 < valList2) {
                mergedListLastNode.next = list1;
                mergedListLastNode = list1;
                list1 = list1.next;
                mergedListLastNode.next = null;
            } else {
                mergedListLastNode.next = list2;
                mergedListLastNode = list2;
                list2 = list2.next;
                mergedListLastNode.next = null;
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