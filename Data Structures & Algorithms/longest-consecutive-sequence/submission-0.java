class Solution {

    class Node {
        int val;
        Node previous = null;
        Node next = null;
        boolean counted = false;
        public Node(int val) {
            this.val = val;
        }
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Node> nodeIndex = new HashMap<>();

        for (int num : nums) {
            if (nodeIndex.get(num) != null) {
                // already computed, do nothing
                continue;
            }

            Node newNode = new Node(num);
            nodeIndex.put(num, newNode);
            
            Node nextNode = nodeIndex.get(num + 1);
            if (nextNode != null) {
                newNode.next = nextNode;
                nextNode.previous = newNode;
            }

            Node previousNode = nodeIndex.get(num - 1);
            if (previousNode != null) {
                newNode.previous = previousNode;
                previousNode.next = newNode;
            }
        }

        int maxSize = 0;
        for (Node node : nodeIndex.values()) {
            if (node.counted) continue;

            int size = 1;
            node.counted = true;
            Node previousNode = node.previous;
            while(previousNode != null) {
                size ++;
                previousNode.counted = true;
                previousNode = previousNode.previous;
            }
            Node nextNode = node.next;
            while(nextNode != null) {
                size ++;
                nextNode.counted = true;
                nextNode = nextNode.next;
            }

            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}
