/*
 * Given a string s, find the longest palindromic substring in s. You mau assume
 * that the maximum length of s is 1000.
 *
 * Example 1:
 *  Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 *
 * Example 2:
 *  Input: "cbbd"
 *  Output: "bb"
 */

class LongestPalindromicSubstring {
    public static boolean isPalindrome(String s) {
        boolean res  = true;

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static String longestPalindrome(String s) {
        int i = 0;
        int j = 1;

        if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return s;
            } else {
                return Character.toString(s.charAt(0));
            }
        } else {
            if (isPalindrome(s)) {
                return s;
            } else {
                while (j < s.length()) {
                    for (i = 0; i <= j; i++) {
                        if (isPalindrome(s.substring(i, (s.length() - j + 2 * i) - i))) {
                            return s.substring(i, (s.length() - j + 2 * i) - i);
                        }
                    }
                    j++;
                }
            }
        }
        return "";
    }

    public static void main(String args[]) {
        String str = "babad";
        System.out.println("For string '" + str + "' its longest palindromic"
                + " substring is '" + longestPalindrome(str) +"'.");

        str = "cbbd";
        System.out.println("For string '" + str + "' its longest palindromic"
                + " substring is '" + longestPalindrome(str) +"'.");

        str = "babaddtattarrattatddetartrateedredividerb";
        System.out.println("For string '" + str + "' its longest palindromic"
                + " substring is '" + longestPalindrome(str) +"'.");

        str = "";
        System.out.println("For string '" + str + "' its longest palindromic"
                + " substring is '" + longestPalindrome(str) +"'.");
        str = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        System.out.println("For string '" + str + "' its longest palindromic"
                + " substring is '" + longestPalindrome(str) +"'.");
    }
}
