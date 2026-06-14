class Solution {

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    static class TrieNode {
        boolean endOfWord = false;
        Map<Character, TrieNode> nodes = new HashMap<>();

        public void insertWord(String word) {
            insertWord(word, 0);
        }

        private void insertWord(String word, int index) {
            if (index == word.length()) {
                endOfWord = true;
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
                List<String> word = findWords(head, board, new Coords(xIt, yIt), new Path());
                if (word != null) {
                    foundWords.addAll(word);
                }
            }
        }
        return foundWords;
    }

    public List<String> findWords(TrieNode head, char[][] board, Coords position, Path currPath) {
        if (position.x < 0 
                || position.y < 0 
                || position.x >= board.length 
                || position.y >= board[0].length) {
            return EMPTY_LIST; // out of bounds
        }

        if (currPath.hasCoords(position)) return EMPTY_LIST; // position already traversed
        
        char currChar = board[position.x][position.y];
        TrieNode nextNode = head.nodes.get(currChar);
        if (nextNode == null) return EMPTY_LIST; // no word with char in position

        currPath.addCoords(position);
        List<String> foundWords = new ArrayList<>();

        if (nextNode.endOfWord) {
            List<Coords> allCoords = currPath.getAllCoords();
            // TODO: actually remove word from trie
            nextNode.endOfWord = false;
            StringBuilder wordSb = new StringBuilder();
            for (Coords c : allCoords) {
                wordSb.append(Character.toString(board[c.x][c.y]));
            }
            foundWords.add(wordSb.toString()); // word found
        }

        List<Coords> candidatePositions = List.of(
            new Coords(position.x + 1, position.y),
            new Coords(position.x - 1, position.y),
            new Coords(position.x, position.y + 1),
            new Coords(position.x, position.y - 1)
        );
        for (Coords candidatePosition : candidatePositions) {
            foundWords.addAll(findWords(nextNode, board, candidatePosition, currPath));
        }

        currPath.removeLastCoords();
        return foundWords;
    }
}
