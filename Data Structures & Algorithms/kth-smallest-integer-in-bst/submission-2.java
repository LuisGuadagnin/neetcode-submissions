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
    int visitedNodes;

    public int kthSmallest(TreeNode root, int k) {
        visitedNodes = 0;

        TreeNode foundNode = visit(root, k);
        return foundNode.val;
    }

    private TreeNode visit(TreeNode currNode, int k) {
        if (currNode == null) return null;
        
        TreeNode foundOnLeft = visit(currNode.left, k);
        if (foundOnLeft != null) return foundOnLeft;

        visitedNodes ++;
        if (k == visitedNodes) return currNode;

        return visit(currNode.right, k);
    }

}
