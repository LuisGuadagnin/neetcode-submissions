class Solution {

    class SubstringCandidates {
        char character;
        int length = 0;
        LinkedList<Integer> replacements = new LinkedList<>();
    }

    public int characterReplacement(String s, int k) {
        SubstringCandidates[] candidates = new SubstringCandidates[26];
        int maxLength = 0;

        for (int i = 0; i < 26; i++) {
            candidates[i] = new SubstringCandidates();
            candidates[i].character = (char)(i + 'A');
        }

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            for (SubstringCandidates candidate : candidates) {
                if (candidate.character == currChar) {
                    candidate.length ++;
                } else {
                    candidate.replacements.add(i);
                    if (candidate.replacements.size() > k) {
                        int earliestReplacement = candidate.replacements.poll();
                        candidate.length = i - earliestReplacement;
                    } else {
                        candidate.length ++;
                    }
                }
                maxLength = Math.max(maxLength, candidate.length);
            }
        }

        return maxLength;
    }
}
