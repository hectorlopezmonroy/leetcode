/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * string convert(string text, int nRows);
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

import java.util.Arrays;

class ZigZagConversion {

    public static String convert(String s, int numRows) {
        int j = 0;
        String res = "";
        boolean up = false;
        boolean down = true;
        String[] temp = new String[numRows];
        Arrays.fill(temp, "");

        if (numRows == 1) {
            return s;
        } else if (numRows > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (down) {
                    if (j % numRows != numRows - 1) {
                        temp[j] = temp[j] + Character.toString(s.charAt(i));
                        j++;
                    } else if (j % numRows == numRows - 1) {
                        temp[j] = temp[j] + Character.toString(s.charAt(i));
                        j--;
                        down = false;
                        up = true;
                    }
                } else if (up) {
                    if (j % numRows == 0) {
                        temp[j] = temp[j] + Character.toString(s.charAt(i));
                        j++;
                        up = false;
                        down = true;
                    } else if (j % numRows != 0) {
                        temp[j] = temp[j] + Character.toString(s.charAt(i));
                        j--;
                    }
                }
            }
            for (int i = 0; i < numRows; i++) {
                res = res + temp[i];
            }
        }
        return res;
    }

    public static void main(String args[]) {
        String str = "PAYPALISHIRING";

        System.out.println("The ZigZag conversion of string '" + str + "' is '"
                + convert(str, 3) + "'.");

        str = "AB";
        System.out.println("The ZigZag conversion of string '" + str + "' is '"
                + convert(str, 1) + "'.");
    }
}
