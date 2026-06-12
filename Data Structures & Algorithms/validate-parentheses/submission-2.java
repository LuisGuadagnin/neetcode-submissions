class Solution {
    public boolean isValid(String s) {
        Stack<Character> openBracketStack = new Stack<>();

        Map<Character, Character> reverseBracketMap = Map.of(
            '}', '{',
            ']', '[',
            ')', '(' 
        );
        Set<Character> openBracketSet = new HashSet<>(reverseBracketMap.values());
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (openBracketSet.contains(currChar)) {
                openBracketStack.push(currChar);
            } else if (openBracketStack.isEmpty()) {
                return false;
            } else {
                char expectedOpenBracket = reverseBracketMap.get(currChar);
                char actualOpenBracket = openBracketStack.pop();
                if (expectedOpenBracket != actualOpenBracket) return false;
            }
        }
        return openBracketStack.isEmpty();
    }
}
