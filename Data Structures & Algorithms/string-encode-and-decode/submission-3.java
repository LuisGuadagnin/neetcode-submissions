class Solution {

    private final static char DELIMITER = '|';
    private final static String DELIMITER_AS_STR = Character.toString(DELIMITER);

    // length|stringlength|string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length() + DELIMITER_AS_STR + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        char[] strAsCharArray = str.toCharArray();

        int i = 0;
        while (i < str.length()) {
            int lengthStart = i;
            char currChar = strAsCharArray[i];
            while (currChar != DELIMITER) {
                currChar = strAsCharArray[i];
                i++;
            }
            int lengthEnd = i;

            String lengthStr = str.substring(lengthStart, lengthEnd - 1);
            int length = Integer.parseInt(lengthStr);

            int wordStart = lengthEnd;
            int wordEnd = wordStart + length;
            String word = str.substring(wordStart, wordEnd);
            result.add(word);
            
            i = wordEnd;
        }
        
        return result;
    }


}
