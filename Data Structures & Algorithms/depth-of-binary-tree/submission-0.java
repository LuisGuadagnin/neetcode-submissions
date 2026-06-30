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
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode root, int currDepth) {
        if (root == null) return 0;

        int depthLeft = maxDepth(root.left, currDepth + 1);
        int depthRight = maxDepth(root.right, currDepth + 1);
        return Math.max(Math.max(currDepth, depthLeft), depthRight);
    }
}
