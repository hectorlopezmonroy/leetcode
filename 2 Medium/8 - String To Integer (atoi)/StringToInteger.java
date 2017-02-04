public class StringToInteger {

	public static int myAtoi(String str) {
		char c;
		int numC;
		int sign = 0;
		int res = 0;
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
