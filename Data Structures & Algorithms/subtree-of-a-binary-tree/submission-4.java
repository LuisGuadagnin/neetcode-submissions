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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return recursivelyEquals(root, subRoot) 
                || isSubtree(root.left, subRoot) 
                || isSubtree(root.right, subRoot);
    }

    private boolean recursivelyEquals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else if (node1.val != node2.val) return false;

        return recursivelyEquals(node1.left, node2.left)
                && recursivelyEquals(node1.right, node2.right);
    }
}
