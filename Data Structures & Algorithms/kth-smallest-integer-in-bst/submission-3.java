/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger visitedNodes = new AtomicInteger(0);

        TreeNode foundNode = visit(root, k, visitedNodes);
        return foundNode.val;
    }

    private TreeNode visit(TreeNode currNode, int k, AtomicInteger visitedNodes) {
        if (currNode == null) return null;
        
        TreeNode foundOnLeft = visit(currNode.left, k, visitedNodes);
        if (foundOnLeft != null) return foundOnLeft;

        int newVisitedNodes = visitedNodes.incrementAndGet();
        if (k == newVisitedNodes) return currNode;

        return visit(currNode.right, k, visitedNodes);
    }

}
