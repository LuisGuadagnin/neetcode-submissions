class Solution {

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    static class TrieNode {
        String word;
        Map<Character, TrieNode> nodes = new HashMap<>();

        public void insertWord(String word) {
            insertWord(word, 0);
        }

        private void insertWord(String word, int index) {
            if (index == word.length()) {
                this.word = word;
            }
            else {
                char characterToInsert = word.charAt(index);
                TrieNode nextNode = nodes.get(characterToInsert);
                if (nextNode == null) {
                    nextNode = new TrieNode();
                    nodes.put(characterToInsert, nextNode);
                }
                nextNode.insertWord(word, index + 1);
            }
        }

        public void removeWord(String word) {
            removeWord(word, 0);
        }

        private void removeWord(String word, int index) {
            if (index == word.length()) {
                this.word = null;
            }
            else {
                char currChar = word.charAt(index);
                TrieNode nextNode = nodes.get(currChar);
                nextNode.removeWord(word, index + 1);
                if (nextNode.word == null && nextNode.nodes.isEmpty()) {
                    nodes.remove(currChar);
                }
            }
        }
    }

    record Coords(int x, int y) {}

    static class Path {
        private List<Coords> path = new ArrayList<>();
        private Set<Coords> indexedPath = new HashSet<>();

        public void addCoords(Coords c) {
            path.add(c);
            // TODO: check if c exists and throw exception
            indexedPath.add(c);
        }

        public boolean hasCoords(Coords c) {
            return indexedPath.contains(c);
        }

        public void removeLastCoords() {
            Coords toRemove = path.get(path.size() - 1);
            path.remove(path.size() - 1);
            indexedPath.remove(toRemove);
        }

        public List<Coords> getAllCoords() {
            return path;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode head = new TrieNode();
        for (String word : words) {
            head.insertWord(word);
        }
        List<String> foundWords = new ArrayList<>();
        for (int xIt = 0; xIt < board.length; xIt++) {
            for (int yIt = 0; yIt < board[xIt].length; yIt++) {
                findWords(head, head, board, new Coords(xIt, yIt), foundWords);
            }
        }
        return foundWords;
    }

    public void findWords(TrieNode head, TrieNode currNode, char[][] board, Coords position, List<String> foundWords) {
        if (position.x < 0 
                || position.y < 0 
                || position.x >= board.length 
                || position.y >= board[0].length) {
            return; // out of bounds
        }

        char currChar = board[position.x][position.y];
        if (currChar == '#') return; // already traversed

        TrieNode nextNode = currNode.nodes.get(currChar);
        if (nextNode == null) return; // no word with char in position

        board[position.x][position.y] = '#';

        if (nextNode.word != null) {
            foundWords.add(nextNode.word); // word found
            head.removeWord(nextNode.word);
        }

        List<Coords> candidatePositions = List.of(
            new Coords(position.x + 1, position.y),
            new Coords(position.x - 1, position.y),
            new Coords(position.x, position.y + 1),
            new Coords(position.x, position.y - 1)
        );
        for (Coords candidatePosition : candidatePositions) {
            findWords(head, nextNode, board, candidatePosition, foundWords);
        }

        board[position.x][position.y] = currChar;
    }
}
