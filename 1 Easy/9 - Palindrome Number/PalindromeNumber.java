/*
 * Determine wheter an integer is a palindrome. Do this without extra space.
 */

import java.lang.Math;

class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		int reverse = 0;

		// negative numbers aren't valid palindromes
		// also any number that ends with zero but starts with a different
		// number isn't a valid palindrome.
		if ((x < 0) || ((x != 0) && ((x % 10) == 0))) {
			return false;
		}
		while (x > reverse) {
			reverse = (reverse * 10) + (x % 10);
			x = x / 10;
		}
		return ((x == reverse) || (x == reverse / 10));
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
