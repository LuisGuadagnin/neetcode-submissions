class Solution {

    // Map {key = Node: value = List of connected Nodes}
    // {
    //   1 -> [0, 2]
    //   0 -> [1]
    //   2 -> [1]
    //   3 -> [4]
    //   4 -> [3]
    // }
    //
    // analyzedNodes {
    //   0, 1, 2
    // }
    //
    // node=0 / analyzedNodes={}
    //   add to analyzedNodes -> analyzedNodes={0}
    //   retrieve all edges -> edges = [1]
    //   groups ++;
    //
    // node=1 / analyzedNodes={0}
    //   add to analyzedNodes -> analyzedNodes={0,1}
    //   retrieve all edges -> [0, 2]
    //
    //
    //

    public int countComponents(int n, int[][] edges) {

        // build Map of connected nodes
        Map<Integer, List<Integer>> mapConnectedNodes = new HashMap<>();
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            List<Integer> nodeAConnectedNodes = mapConnectedNodes.getOrDefault(nodeA, new ArrayList<>());
            nodeAConnectedNodes.add(nodeB);
            mapConnectedNodes.put(nodeA, nodeAConnectedNodes);

            List<Integer> nodeBConnectedNodes = mapConnectedNodes.getOrDefault(nodeB, new ArrayList<>());
            nodeBConnectedNodes.add(nodeA);
            mapConnectedNodes.put(nodeB, nodeBConnectedNodes);
        }

        Set<Integer> analyzedNodes = new HashSet<>();
        int amountOfGroups = 0;
        for (Integer node : mapConnectedNodes.keySet()) {
            if (analyzedNodes.contains(node)) continue;

            amountOfGroups++;
            recursivelyMarkAsAnalyzed(node, mapConnectedNodes, analyzedNodes);
        }
        return amountOfGroups + (n - mapConnectedNodes.keySet().size());
    }

    private void recursivelyMarkAsAnalyzed(Integer node, Map<Integer, List<Integer>> mapConnectedNodes, Set<Integer> analyzedNodes) {
        if (analyzedNodes.contains(node)) return;

        analyzedNodes.add(node);
        List<Integer> connectedNodes = mapConnectedNodes.get(node);
        connectedNodes.forEach(connectedNode -> recursivelyMarkAsAnalyzed(connectedNode, mapConnectedNodes, analyzedNodes));
    }
}
