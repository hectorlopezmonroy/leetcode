/*
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 2 -> (a, b, c)
 * 3 -> (d, e, f)
 * 4 -> (g, h, i)
 * 5 -> (j, k, l)
 * 6 -> (m, n, o)
 * 7 -> (p, q, r, s)
 * 8 -> (t, u, v)
 * 9 -> (w, x, y, z)
 *
 * Example:
 * 	Input: Digit string "23"
 * 	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */

import java.util.List;
import java.util.LinkedList;

class LetterCombinationsOfAPhoneNumber {

    public static void display(List<String> l) {
        System.out.print("[");
        for (int i = 0; i < l.size(); i++) {
            if (i < l.size() - 1) {
                System.out.print("'" + l.get(i) + "', ");
            } else {
                System.out.print("'" + l.get(i) + "'");
            }
        }
        System.out.println("]");
    }

    public static List<String> letterCombinations(String digits) {
        int i = 0;
        List<String> res = new LinkedList<String>();
        char[][] mappedChars = {{'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

        if (digits.contains("1") || digits.length() == 0) {
            return res;
        }
        do {
            char c = digits.charAt(i);
            short d = (short) Character.getNumericValue(c);
            if (i == 0) {
                for (int j = 0; j < mappedChars[d - 2].length; j++) {
                    res.add(Character.toString(mappedChars[d - 2][j]));
                }
            } else {
                while (res.get(0).length() == i) {
                    String prefix = res.remove(0);
                    for (int j = 0; j < mappedChars[d - 2].length; j++) {
                        res.add(prefix.concat(Character.toString(mappedChars[d - 2][j])));
                    }
                }
            }
            i++;
        } while (i < digits.length());

        return res;
    }

    public static void main(String args[]) {
        String str = "";
        List<String> combinations;

        System.out.print("For string '" + str
                + "' its letter combinations are " );
        combinations = letterCombinations(str);
        display(combinations);

        str = "1";
        System.out.print("For string '" + str
                + "' its letter combinations are " );
        combinations = letterCombinations(str);
        display(combinations);

        str = "2";
        System.out.print("For string '" + str
                + "' its letter combinations are " );
        combinations = letterCombinations(str);
        display(combinations);

        str = "23";
        System.out.print("For string '" + str
                + "' its letter combinations are " );
        combinations = letterCombinations(str);
        display(combinations);

        str = "29";
        System.out.print("For string '" + str
                + "' its letter combinations are " );
        combinations = letterCombinations(str);
        display(combinations);
    }
}
