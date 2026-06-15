class Solution {

    static class AlienDictionaryException extends RuntimeException {}

    static class Node {
        char character;
        Set<Node> next = new HashSet<>();
        int amountOfEntryPoints = 0;
    }

    record Constraint(char predecessor, char successor) {}

    public String foreignDictionary(String[] words) {

        /* Initializes nodes for all characters */
        Node[] nodes = new Node[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                int posC = c - 'a';

                if (nodes[posC] == null) {
                    nodes[posC] = new Node();
                    nodes[posC].character = c;
                }
            }
        }

        /* Creates constraints by comparing pairs of words */
        Set<Constraint> allConstraints = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            try {
                Constraint constraint = compareWordPair(words[i-1], words[i], nodes);
                if (constraint != null) {
                    allConstraints.add(constraint);
                }
            } catch(AlienDictionaryException ex) {
                return "";
            }
        }

        /* Builds graph */
        for (Constraint constraint : allConstraints) {
            char predecessor = constraint.predecessor();
            int posPredecessor = predecessor - 'a';
            Node nodePredecessor = nodes[posPredecessor];

            char successor = constraint.successor();
            int posSuccessor = successor - 'a';
            Node nodeSuccessor = nodes[posSuccessor];

            nodePredecessor.next.add(nodeSuccessor);
            nodeSuccessor.amountOfEntryPoints++;
        }

        /* Create topological order */
        List<Node> nodesTopologicalOrder = new ArrayList<>();
        /* 1. Adds nodes with 0 entry points */
        for (Node node : nodes) {
            if (node != null && node.amountOfEntryPoints == 0) {
                nodesTopologicalOrder.add(node);
            }
        }
        /* 2. Iterates through nextNodes, decrement entry points, add if 0 */
        for (int i = 0; i < nodesTopologicalOrder.size(); i++) {
            Node currNode = nodesTopologicalOrder.get(i);
            for (Node nextNode : currNode.next) {
                nextNode.amountOfEntryPoints--;
                if (nextNode.amountOfEntryPoints == 0) {
                    nodesTopologicalOrder.add(nextNode);
                }
            }
        }

        for (Node node: nodes) {
            if (node != null && node.amountOfEntryPoints != 0) {
                return "";
            }
        }

        /* Builds alphabet from topological order */
        StringBuilder sb = new StringBuilder();
        for (Node node : nodesTopologicalOrder) {
            sb.append(Character.toString(node.character));
        }
        return sb.toString();
        
    }

    public Constraint compareWordPair(String word1, String word2, Node[] nodes) {
        for (int i = 0; i < word1.length(); i++) {
            if (i >= word2.length()) {
                throw new AlienDictionaryException();
            }

            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if (char1 != char2) {
                return new Constraint(char1, char2);
            }
        }
        return null;
    }
}
