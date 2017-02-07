/*
 * Reverse digits of an integer.
 *
 * Example 1:
 * 	x = 123, return 321
 *
 * Example 2:
 * 	x = -123, return -321
 *
 * The input is assumed to be a 32-bit signed integer. Your function should
 * return 0 when the reversed integer overflows.
 */
import java.util.Vector;

public class ReverseInteger {
	public static int reverse(int x) {
		int j = 0;
		int i = 10;
		int res = 0;
		int temp = 0;
		Vector<Integer> digits = new Vector<>();

		while (x != 0) {
			digits.add(x % i);
			x = x / 10;
			j = j + 1;
		}
		for (int k = 0; k < digits.size(); k++) {
			try {
				temp = Math.multiplyExact(digits.get(k),
										  (int) Math.pow(10, digits.size() - k - 1));
				res = Math.addExact(res, temp);
			} catch (ArithmeticException e) {
				return 0;
			}
		}
		return res;
	}

	public static void main (String args[]) {
		int num = -2147483412;

		System.out.println("The reverse of " + num + " is " + reverse(num));
	}
}
