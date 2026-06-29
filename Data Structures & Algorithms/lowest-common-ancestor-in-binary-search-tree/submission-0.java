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

    record Result(TreeNode nodeFound, int amountFound) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        
        findAncestorList(root, p, pAncestors);
        findAncestorList(root, q, qAncestors);

        Set<TreeNode> pAncestorsIndexed = new HashSet<>(pAncestors);
        for (int i = qAncestors.size() - 1; i >= 0; i--) {
            TreeNode commonAncestorCandidate = qAncestors.get(i);
            if (pAncestorsIndexed.contains(commonAncestorCandidate)) {
                return commonAncestorCandidate;
            }
        }
        return null;
    }

    public void findAncestorList(TreeNode currentNode, TreeNode toFind, List<TreeNode> ancestorList) {
        ancestorList.add(currentNode);
        if (currentNode.val == toFind.val) {
            return;
        } else if (currentNode.val > toFind.val) {
            findAncestorList(currentNode.left, toFind, ancestorList);
        } else {
            findAncestorList(currentNode.right, toFind, ancestorList);
        }
    }
}
