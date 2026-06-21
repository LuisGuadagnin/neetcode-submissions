class PrefixTree {

    class TrieNode {
        Map<Character, TrieNode> edges = new HashMap<>();
        boolean endOfWord = false;
    }

    private TrieNode head;

    public PrefixTree() {
        head = new TrieNode();
    }

    private void insert(TrieNode currNode, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            currNode.endOfWord = true;
        } else {
            char nextChar = word.charAt(wordIndex);
            TrieNode nextNode = currNode.edges.getOrDefault(nextChar, new TrieNode());
            currNode.edges.put(nextChar, nextNode);
            insert(nextNode, word, wordIndex + 1);
        }
    }

    public void insert(String word) {
        insert(head, word, 0);
    }

    private boolean search(TrieNode currNode, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return currNode.endOfWord;
        } else {
            char nextChar = word.charAt(wordIndex);
            TrieNode nextNode = currNode.edges.get(nextChar);
            if (nextNode == null) return false;
            return search(nextNode, word, wordIndex + 1);
        }
    }

    public boolean search(String word) {
        return search(head, word, 0);
    }

    private boolean startsWith(TrieNode currNode, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        } else {
            char nextChar = word.charAt(wordIndex);
            TrieNode nextNode = currNode.edges.get(nextChar);
            if (nextNode == null) return false;
            return startsWith(nextNode, word, wordIndex + 1);
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(head, prefix, 0);
    }
}
