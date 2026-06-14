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
        Set<ListNode> traversedNodes = new HashSet<>();
        ListNode currNode = head;

        while(currNode != null) {
            if (traversedNodes.contains(currNode)) {
                return true;
            }
            traversedNodes.add(currNode);
            currNode = currNode.next;
        }
        return false;
    }
}
