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

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode head = new TrieNode();
        for (String word : words) {
            head.insertWord(word);
        }
        List<String> foundWords = new ArrayList<>();
        for (int xIt = 0; xIt < board.length; xIt++) {
            for (int yIt = 0; yIt < board[xIt].length; yIt++) {
                findWords(head, head, board, xIt, yIt, foundWords);
            }
        }
        return foundWords;
    }

    public void findWords(TrieNode head, TrieNode currNode, char[][] board, int x, int y, List<String> foundWords) {
        if (x < 0 
                || y < 0 
                || x >= board.length 
                || y >= board[0].length) {
            return; // out of bounds
        }

        char currChar = board[x][y];
        if (currChar == '#') return; // already traversed

        TrieNode nextNode = currNode.nodes.get(currChar);
        if (nextNode == null) return; // no word with char in position

        board[x][y] = '#';

        if (nextNode.word != null) {
            foundWords.add(nextNode.word); // word found
            head.removeWord(nextNode.word);
        }

        findWords(head, nextNode, board, x + 1, y, foundWords);
        findWords(head, nextNode, board, x - 1, y, foundWords);
        findWords(head, nextNode, board, x, y + 1, foundWords);
        findWords(head, nextNode, board, x, y - 1, foundWords);

        board[x][y] = currChar;
    }
}
