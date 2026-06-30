class Solution {

    private final static char DELIMITER = '|';
    private final static String DELIMITER_AS_STR = Character.toString(DELIMITER);

    // length|string|length|string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length() + DELIMITER_AS_STR + str + DELIMITER_AS_STR);
        }
        if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        char[] strAsCharArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean readingLength = true;
        int currLength = 0;
        int strIterator = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (readingLength) {
                char c = str.charAt(i);
                if (c == DELIMITER) {
                    currLength = Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                    readingLength = false;
                } else {
                    sb.append(c);
                }
            } else {
                if (strIterator == currLength) {
                    String newString = sb.toString();
                    result.add(newString);
                    sb = new StringBuilder();
                    readingLength = true;
                    strIterator = 0;
                } else {
                    char c = str.charAt(i);
                    sb.append(c);
                    strIterator++;
                }
            }
        }
        return result;
    }
}
