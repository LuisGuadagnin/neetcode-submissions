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
        List<TreeNode> candidates = findSubRootCandidates(root, subRoot);
        for (TreeNode node : candidates) {
            if (recursivelyEquals(node, subRoot)) {
                return true;
            }
        }
        return false;
    }

    private List<TreeNode> findSubRootCandidates(TreeNode currNode, TreeNode subRoot) {
        if (currNode == null) return new ArrayList<>();

        List<TreeNode> candidates = new ArrayList<>();
        if (currNode.val == subRoot.val) candidates.add(currNode);
        candidates.addAll(findSubRootCandidates(currNode.left, subRoot));
        candidates.addAll(findSubRootCandidates(currNode.right, subRoot));
        return candidates;
    }

    private boolean recursivelyEquals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else if (node1.val != node2.val) return false;

        return recursivelyEquals(node1.left, node2.left)
                && recursivelyEquals(node1.right, node2.right);
    }
}
