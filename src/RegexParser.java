public class RegexParser {
    static boolean isMatch(String text, String pattern) {
        if (text.equals(pattern))
            return true;

        if (text.isEmpty() && pattern.length() == 2 && pattern.charAt(1) == '*')
            return true;

        int i = 0;
        int j = 0;

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
                i++;
                j++;
            } else {
                if (j < pattern.length() && pattern.charAt(j) == '*') {
                    while (i < text.length() && text.charAt(i) == text.charAt(i - 1))
                        i++;
                    j++;
                } else if (j < pattern.length() && pattern.charAt(j + 1) == '*') {
                    j += 2;
                } else
                    return false;
            }
        }
        return i == text.length() && j == pattern.length();
    }

    public static void main(String[] args) {
        isMatch("acd", "ab*c.");
    }

    /**
     * if(text.equals(pattern))
     *       return true;
     *     int i=0;
     *     int j=0;
     *     int lenPattern = pattern.length();
     *     int lenText = text.length();
     *     while(i<lenPattern){
     *       if(i<lenPattern-1 && pattern.charAt(i+1)=='*'){
     *         if(j<lenText){
     *           if(pattern.charAt(i)=='.')
     *             j++;
     *           else if(pattern.charAt(i)!=text.charAt(j))
     *             i+=2;
     *           else if(pattern.charAt(i)==text.charAt(j))
     *             j++;
     *         }
     *         else
     *           i+=2;
     *       }
     *       else if(j<lenText && (pattern.charAt(i)==text.charAt(j) || pattern.charAt(i)=='.')){
     *         j++;
     *         i++;
     *       }
     *       else
     *         return false;
     *     }
     *     if(i==lenPattern && j==lenText)
     *       return true;
     *     return false;
     */

}
