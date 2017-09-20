/*
 * Implement atoi to convert a string to an integer
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (i.e., no
 * given input specs). You are responsible to gather all the input.
 *
 * SPOILERS ALERT (Requirements for atoi below):
 *
 *	Requirements for atoi:
 *	  The function first discards as many whitespace characters as necessary
 *	  until the first non-whitespace character is found. Then, starting from
 *	  this character, takes an optional plus or minus sign followed by as many
 *	  numerical digits as possible, and interprets them as a numerical value.
 *
 *	  The string can contain additional characters after those that form the
 *	  integral number, which are ignored and have no effect on the behavior of
 *	  this function.
 *
 *	  If the first sequence of non-whitespace characters in str is not a valid
 *	  integral number, or if no such sequence exists because either str is empty
 *	  or it contains only whitespace characters, no conversion is performed.
 *
 *	  If no valid conversion could be performed a zero value is returned. If the
 *	  correct value is out of the range of representable values, INT_MAX
 *	  (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class StringToInteger {

    public static int myAtoi(String str) {
        char c;
        int numC;
        int res = 0;
        int sign = 0;
        boolean foundValid = false;

        for (int i = 0; i < str.length(); i++) {
            c =  str.charAt(i);
            numC = Character.getNumericValue(c);

            if (c == ' ') {
                // nothing to do if blank found at the beggining of the string,
                // if found after a valid character, stop reading and return res
                if (foundValid){
                    break;
                }
            } else if (c == '+') {
                if (foundValid) {
                    break;
                }
                sign = 1;
                foundValid = true;
            } else if (c == '-') {
                if (foundValid) {
                    break;
                }
                sign = -1;
                foundValid = true;
            } else if (0 <= numC && numC <= 9) {
                System.out.print("res1 = " + res + ", numC = " + numC
                        + " -> " + res + " * 10 + " + numC +" = ");
                foundValid = true;
                try {
                    if ((sign == 0) || (sign == 1)) {
                        res = Math.addExact(Math.multiplyExact(res, 10), numC);
                    } else if (sign == -1){
                        res = Math.subtractExact(Math.multiplyExact(res, 10), numC);
                    }
                    System.out.println(" res2 = " + res);
                } catch (ArithmeticException e) {
                    System.out.println("Overflow");
                    if ((sign == 0) || (sign == 1)) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }

        if (Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE) {
            return res;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String args[]) {
        String s = "2147483648";

        System.out.println(""+Integer.MAX_VALUE);
        System.out.println(""+Integer.MIN_VALUE);
        System.out.println("The integer value of the string "
                + s + " is " + myAtoi(s));
    }
}
