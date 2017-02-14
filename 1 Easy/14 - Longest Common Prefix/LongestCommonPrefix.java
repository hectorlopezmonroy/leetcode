/*
 * Write a function to find the longest common prefix amongst an array of
 * strings.
 */

class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		String res = strs.length > 0 ? strs[0] : "";

		for (int i = 1; i < strs.length; i++) {
			String smaller;
			if (res.length() >= strs[i].length()) {
				smaller = strs[i];
			} else {
				smaller = res;
			}

			for (int j = 0; j < smaller.length(); j++) {
				if (res.charAt(j) != strs[i].charAt(j)) {
					if (j == 0) {
						return "";
					} else {
						smaller = res.substring(0, j);
					}
				}
			}
			res = smaller;
		}
		return res;
	}

	public static void main(String args[]) {
		String[] strs0 = {};
		String[] strs1 = {"word"};
		String[] strs3 = {"somethings", "something", "some"};
		String[] strs4 = {"baab", "bacb", "b", "cbc"};


		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs0) + "'.");

		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs1) + "'.");

		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs3) + "'.");

		strs3[0] = "au";
		strs3[2] = "pp";
		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs3) + "'.");

		strs3[0] = "flower";
		strs3[1] = "flow";
		strs3[2] = "flight";
		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs3) + "'.");

		System.out.println("The longest common prefix is '"
							+ longestCommonPrefix(strs4) + "'.");
	}
}
