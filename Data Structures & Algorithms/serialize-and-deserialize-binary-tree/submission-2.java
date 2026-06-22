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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> nodeBuffer = new LinkedList<>();
        
        nodeBuffer.push(root);

        while(!nodeBuffer.isEmpty()) {
            TreeNode currNode = nodeBuffer.pollFirst();
            if (currNode == null) {
                sb.append("#N");
            }
            else {
                sb.append("#" + currNode.val);

                TreeNode leftNode = currNode.left;
                nodeBuffer.offerLast(leftNode);

                TreeNode rightNode = currNode.right;
                nodeBuffer.offerLast(rightNode);
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] numbersStr = data.split("#");
        
        TreeNode head = new TreeNode(Integer.parseInt(numbersStr[0]));
        LinkedList<TreeNode> evaluateChildrenQueue = new LinkedList<>();
        evaluateChildrenQueue.offer(head);

        for(int i = 1; i < numbersStr.length; i+=2) {
            TreeNode parent = evaluateChildrenQueue.pollFirst();
            
            if (!numbersStr[i].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(numbersStr[i]));
                evaluateChildrenQueue.offerLast(parent.left);
            }
            if (!numbersStr[i+1].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(numbersStr[i+1]));
                evaluateChildrenQueue.offerLast(parent.right);
            }
        }
        return head;
    }
}
