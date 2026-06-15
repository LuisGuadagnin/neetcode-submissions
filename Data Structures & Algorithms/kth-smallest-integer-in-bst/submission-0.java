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
        /* Compute the amount of nodes under each node, including the node */
        Map<TreeNode, Integer> amountOfNodes = new HashMap<>();
        findAndComputeNode(root, amountOfNodes);
        TreeNode kthSmallest = findNthSmallest(root, k, amountOfNodes);
        return kthSmallest.val;
    }

    public int findAndComputeNode(TreeNode currNode, Map<TreeNode, Integer> amountOfNodes) {
        if (currNode == null) return 0;

        int amount = 1 + findAndComputeNode(currNode.left, amountOfNodes) + findAndComputeNode(currNode.right, amountOfNodes);
        amountOfNodes.put(currNode, amount);
        return amount;
    }

    public TreeNode findNthSmallest(TreeNode currNode, int k, Map<TreeNode, Integer> amountOfNodes) {
        int nodesToLeft = currNode.left == null ? 0 : amountOfNodes.get(currNode.left);
        if (nodesToLeft >= k) {
            return findNthSmallest(currNode.left, k, amountOfNodes);
        }

        if (nodesToLeft + 1 == k) {
            return currNode;
        }

    
        int newK = k - nodesToLeft - 1;
        return findNthSmallest(currNode.right, newK, amountOfNodes);
    }
}
