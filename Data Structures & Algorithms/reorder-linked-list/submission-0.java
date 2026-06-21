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
    private List<ListNode> linkedListToArrayList(ListNode head) {
        List<ListNode> newList = new ArrayList<>();
        while (head != null) {
            newList.add(head);
            head = head.next;
        }
        return newList;
    }

    public void reorderList(ListNode head) {
        List<ListNode> originalOrder = linkedListToArrayList(head);
        
        for (int i = 0; i < originalOrder.size() / 2; i++) {
            int iFromEnd = originalOrder.size() - i - 1;

            ListNode leftNode = originalOrder.get(i);
            ListNode rightNode = originalOrder.get(iFromEnd);

            rightNode.next = leftNode.next;
            leftNode.next = rightNode;
        }
        ListNode lastElement = originalOrder.get(originalOrder.size() / 2);
        lastElement.next = null;
    }
}
