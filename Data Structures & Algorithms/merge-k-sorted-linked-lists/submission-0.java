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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));
        for (ListNode node : lists) {
            minHeap.add(node);
        }

        ListNode head = new ListNode();
        ListNode currElement = head;
        while (!minHeap.isEmpty()) {
            ListNode nextElement = minHeap.poll();
            if (nextElement.next != null) {
                minHeap.add(nextElement.next);
            }
            nextElement.next = null;
            currElement.next = nextElement;
            currElement = nextElement;
        }

        return head.next;
    }
}
