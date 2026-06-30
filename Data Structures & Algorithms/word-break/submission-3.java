class Solution {

    class TrieNode {
        boolean end = false;
        Map<Character, TrieNode> vertices = new HashMap<>();

        public void addWord(String s) {
            this.addWord(s, 0);
        }

        private void addWord(String s, int i) {
            if (i == s.length()) {
                this.end = true;
                return;
            }
            char c = s.charAt(i);
            TrieNode nextNode = vertices.getOrDefault(c, new TrieNode());
            vertices.put(c, nextNode);
            nextNode.addWord(s, i + 1);
        }

        public boolean hasBrokenWord(String s) {
            return hasBrokenWord(s, 0, this, new Boolean[s.length()]);
        }

        private boolean hasBrokenWord(String s, int i, TrieNode head, Boolean[] memo) {
            if (i == s.length()) return this.end;
            if (this == head && memo[i] != null) return memo[i];
            
            char c = s.charAt(i);
            TrieNode nextNode = vertices.get(c);
            if (nextNode != null) {
                boolean foundInNextVertices = nextNode.hasBrokenWord(s, i+1, head, memo);
                if (foundInNextVertices) return true;
            }

            if (this.end) {
                boolean res = head.hasBrokenWord(s, i, head, memo);
                memo[i] = res;
                return res;
            }
            return false;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode trieHead = new TrieNode();
        for(String word : wordDict) {
            trieHead.addWord(word);
        }
        return trieHead.hasBrokenWord(s);

    }
}
