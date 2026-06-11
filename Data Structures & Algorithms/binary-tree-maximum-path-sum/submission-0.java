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

/*

*/

class Solution {
    static class GraphNode {
        GraphNode left;
        GraphNode right;
        GraphNode parent;

        Integer pathStay;
        Integer pathLeft;
        Integer pathRight;
        Integer pathParent;
    }

    public int maxPathSum(TreeNode root) {
        List<GraphNode> allNodes = new ArrayList<>();
        buildGraph(root, null, allNodes);

        Integer maxPath = Integer.MIN_VALUE;
        for (GraphNode node : allNodes) {
            int currPath = getMaxOneWayPath(node, null);
            maxPath = Math.max(maxPath, currPath);
        }
        return maxPath;
    }

    public GraphNode buildGraph(TreeNode currTreeNode, GraphNode parentNode, List<GraphNode> allNodes) {
        if (currTreeNode == null) return null;

        GraphNode node = new GraphNode();
        allNodes.add(node);
        node.pathStay = currTreeNode.val;
        node.left = buildGraph(currTreeNode.left, node, allNodes);
        node.right = buildGraph(currTreeNode.right, node, allNodes);
        node.parent = parentNode;
        return node;
    }

    public int getMaxOneWayPath(GraphNode node, GraphNode callerNode) {
        if (node == null) return 0;
        int maxPath = node.pathStay;
        if (node.left != callerNode) {
            if (node.pathLeft == null) {
                node.pathLeft = getMaxOneWayPath(node.left, node);
            }
            maxPath = Math.max(maxPath, node.pathStay + node.pathLeft);
        }
        if (node.right != callerNode) {
            if (node.pathRight == null) {
                node.pathRight = getMaxOneWayPath(node.right, node);
            }
            maxPath = Math.max(maxPath, node.pathStay + node.pathRight);
        }
        if (node.parent != callerNode) {
            if (node.pathParent == null) {
                node.pathParent = getMaxOneWayPath(node.parent, node);
            }
            maxPath = Math.max(maxPath, node.pathStay + node.pathParent);
        }
        return maxPath;
    }
}
