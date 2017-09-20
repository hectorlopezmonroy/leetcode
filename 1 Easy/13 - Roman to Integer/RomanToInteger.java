/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.Stack;

class RomanToInteger {
    public static int romanDigitToInt(char c) {
        int res = 0;

        if (c == 'I') {
            res = 1;
        } else if (c == 'V') {
            res = 5;
        } else if (c == 'X') {
            res = 10;
        } else if (c == 'L') {
            res = 50;
        } else if (c == 'C') {
            res = 100;
        } else if (c == 'D') {
            res = 500;
        } else if (c == 'M') {
            res = 1000;
        }
        return res;
    }

    public static int romanToInt(String s) {
        int res = 0;
        int temp = 0;
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            if (!st.empty()) {
                if (st.peek() == c) {
                    st.push(c);
                } else if (romanDigitToInt(st.peek()) < romanDigitToInt(c)) {
                    res = res + romanDigitToInt(c) - romanDigitToInt(st.pop());
                } else {
                    while (!st.empty()) {
                        temp = temp + romanDigitToInt(st.pop());
                    }
                    res = res + temp;
                    temp = 0;
                    st.push(c);
                }
            } else {
                st.push(c);
            }
        }
        while (!st.empty()) {
            temp = temp + romanDigitToInt((char) st.pop());
        }
        res = res + temp;

        return res;
    }

    public static void main(String args[]) {
        System.out.println("String li equals " + romanToInt("LI"));
        System.out.println("String III equals " + romanToInt("III"));
        System.out.println("String IV equals " + romanToInt("IV"));
        System.out.println("String MCMLIV equals " + romanToInt("MCMLIV"));
        System.out.println("String MCMXC equals " + romanToInt("MCMXC"));
        System.out.println("String MMXIV equals " + romanToInt("MMXIV"));
        System.out.println("String DCXXI equals " + romanToInt("DCXXI"));
    }
}
