import java.lang.Math;

class PalindromeNumber {
	public static int countDigits(int n) {
		int res = 0;

		// this loop counts how many digits has the integer
		while (n - (int)(Math.pow(10, res + 1)) > 0) {
			res++;
		}
		return (res + 1);
	}

	public static int countLeastSignificativeZeros(int n) {
		int res = 1;

		// this loop counts how many zeros are the least
		// significative digits.
		while (n % (int)(Math.pow(10, res)) == 0) {
			res++;
		}
		return (res - 1);
	}

	public static boolean isPalindrome(int x) {
		int i = 0;

		if ((0 <= x) && (x < 10)) {
			// single digit integers are palindromes
			return true;
		} else if (x < 0) {
			// negative integers are not palindromes
			return false;
		} else {
			while (x != 0) {
				if ((x % 10 == 0) && (i == 0)) {
					// if the least significative digits is zero and this is the
					// first iteration, then the number is not a palindrome
					// (e.g. 7170)
					// The only valid palindromes that this program accepts are
					// of the form d0d0d
					return false;
				} else if ((x % 10 != 0) && (i != 0)) {
					// unless the least significative digits are zeros, each
					// iteration should only remove two digits
					// Preventing a case like 1000021 to be considered a valid
					// palindrome
					int j = countDigits(x);
					if (i - j > 2)
						return false;
				} else if ((x % 10 == 0) && (i > 0)) {
					// checking that the zero has it's corresponding pair
					// and checking how many zeros dissapeared from the previous
					// iteration.
					// Should be equal to the number of least significative
					// digits that are zeros.
					int j = countDigits(x);
					int z = countLeastSignificativeZeros(x);
					if ((i - j == 2 + z)
						&& (((x / (int) Math.pow(10, i - 1)) % 10) == 0)) {
						x = (int) (x / Math.pow(10, z));
					} else {
						return false;
					}
				}
				i = countDigits(x);
				if (i % 2 == 0) {
					// the number has an even count of digits
					if (x % 10 != (x / (int) Math.pow(10, i - 1)) % 10) {
						return false;
					}
				} else {
					// the number has an odd count of digits
					if (x > 9) {
						// the number is larger than one digit but still odd
						if (x % 10 != (x / (int) Math.pow(10, i - 1)) % 10) {
							return false;
						}
					} else {
						// digit in the middle doesn't need any check
						return true;
					}
				}
				x = (int) ((x - ((x % 10) * Math.pow(10, i - 1))) / 10);
			}
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println("Is " + 121 + " a palindrome number? "
							+ isPalindrome(121));

		System.out.println("Is " + 1221 + " a palindrome number? "
							+ isPalindrome(1221));

		System.out.println("Is " + 9999 + " a palindrome number? "
							+ isPalindrome(9999));

		System.out.println("Is " + 70507 + " a palindrome number? "
				+ isPalindrome(70507));

		System.out.println("Is " + 7005007 + " a palindrome number? "
							+ isPalindrome(7005007));

		System.out.println("Is " + 124321 + " a palindrome number? "
							+ isPalindrome(124321));

		System.out.println("Is " + 0123210 + " a palindrome number? "
							+ isPalindrome(0123210));

		System.out.println("Is " + -1 + " a palindrome number? "
							+ isPalindrome(-1));

		System.out.println("Is " + 1000021 + " a palindrome number? "
							+ isPalindrome(1000021));
	}
}
