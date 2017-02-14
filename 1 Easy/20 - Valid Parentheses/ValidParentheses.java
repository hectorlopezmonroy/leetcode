/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */

import java.util.Stack;

class ValidParentheses {
	public static boolean isValid(String s) {
		boolean res = false;
		Stack<Character> st = new Stack<Character>();

		if (s.length() % 2 != 0) {
			return res;
		} else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[' || c == '{') {
					st.push(c);
				} else if (c == ')' || c == ']' || c == '}') {
					if (!st.empty()) {
						if ((st.peek() != '(' && c == ')')
							|| (st.peek() != '[' && c == ']')
							|| (st.peek() != '{' && c == '}')) {
							return false;
						} else if ((st.peek() == '(' && c == ')')
								   || (st.peek() == '[' && c == ']')
								   || (st.peek() == '{' && c == '}')) {
							st.pop();
						}
					} else {
						return false;
					}
				}
			}
			if (st.empty()) {
				res = true;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		String str = "()";

		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "[]";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "{}";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "{}{}()[]";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "{}{}()[]{([])}";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "){";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "{]";
		System.out.println("String '" + str + "' is valid? " + isValid(str));

		str = "{{})";
		System.out.println("String '" + str + "' is valid? " + isValid(str));
	}
}
