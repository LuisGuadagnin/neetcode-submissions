class Solution {

    private static final int DIFF_LOWER_UPPER = 'a' - 'A';

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        s.chars().forEach(ch -> {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(Character.toString(ch + DIFF_LOWER_UPPER));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append(Character.toString(ch));
            } else if (ch >= '0' && ch <= '9') {
                sb.append(Character.toString(ch));
            }
        });
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        String normalizedString = normalize(s);

        int iStart = 0;
        int iEnd = normalizedString.length() - 1;

        while (iStart < iEnd) {
            if (normalizedString.charAt(iStart) != normalizedString.charAt(iEnd)) {
                return false;
            }
            iStart++;
            iEnd--;
        }

        return true;
    }
}
