class Solution {

    class Node {
        int val;
        List<Node> connected = new ArrayList<>();
        boolean visited = false;

        public Node(int val) { this.val = val; }
    }

    private boolean hasCycle(Node node, Node parent) {
        if (node.visited) return true;

        node.visited = true;
        for (Node connectedNode : node.connected) {
            if (connectedNode == parent) continue;
            if (hasCycle(connectedNode, node)) return true;
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return edges.length == 0;

        Map<Integer, Node> indexedNodes = new HashMap<>();

        for (int[] edge : edges) {
            int val1 = edge[0];
            int val2 = edge[1];

            Node node1 = indexedNodes.getOrDefault(val1, new Node(val1));
            Node node2 = indexedNodes.getOrDefault(val2, new Node(val2));
            node1.connected.add(node2);
            node2.connected.add(node1);
            indexedNodes.put(val1, node1);
            indexedNodes.put(val2, node2);
        }

        boolean hasCycle = hasCycle(indexedNodes.get(edges[0][0]), null);
        if (hasCycle) return false;

        for (Node node : indexedNodes.values()) {
            if (!node.visited) return false;
        }

        return n == indexedNodes.size();
    }

/*

 0 - 1 - 2 - 3
     |\-----/
     4
*/
}
