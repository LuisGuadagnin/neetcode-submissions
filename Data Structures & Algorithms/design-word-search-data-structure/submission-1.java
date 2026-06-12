class WordDictionary {

/*
    // bad, bay

          .
          |
          b
          |
          .
          |
          a
          |
          .
        /   \
       d     y
      /       \
     .         .

*/

    static class TreeNode {
        private Map<Character, TreeNode> nodes = new HashMap<>();
        private boolean wordEnd = false;
        public Optional<TreeNode> getNode(Character c) {
            return Optional.ofNullable(nodes.get(c));
        }
        public Collection<TreeNode> getAllNodes() {
            return nodes.values();
        }
        public TreeNode getOrCreateNode(Character c) {
            return getNode(c).orElseGet(() -> {
                TreeNode newNode = new TreeNode();
                nodes.put(c, newNode);
                return newNode;
            });
        }
        public void markAsEndOfWord() {
            wordEnd = true;
        }
        public boolean isEndOfWord() {
            return wordEnd;
        }
    }

    TreeNode headNode;

    public WordDictionary() {
        headNode = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode currNode = headNode;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            currNode = currNode.getOrCreateNode(currChar);
        }
        currNode.markAsEndOfWord();
    }

    public boolean search(String word) {
        return search(word, 0, headNode);
    }

    public boolean search(String word, int index, TreeNode currNode) {
        if (index == word.length()) return currNode.isEndOfWord();
        char currChar = word.charAt(index);

        if (currChar == '.') {
            for (TreeNode newNode : currNode.getAllNodes()) {
                boolean foundWord = search(word, index + 1, newNode);
                if (foundWord) return true;
            }
            return false;
        } else {
            return currNode.getNode(currChar)
                .map(newNode -> search(word, index + 1, newNode))
                .orElse(false);
        }
    }
}
