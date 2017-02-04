/*
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which is length 3.
 * Given "bbbbb", the answer is "b", with length 1.
 * Given "pwwkew", the answer is "wke", with length 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 */
import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int currentSubseqSize = 0;
		int currentSubseqIndex = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) < currentSubseqIndex) {
					currentSubseqSize = currentSubseqSize + 1;
				} else if (map.get(c) >= currentSubseqIndex) {
					if (max < (i - currentSubseqIndex)) {
						max = i - currentSubseqIndex;
					}
					if (map.get(c) == currentSubseqIndex) {
						currentSubseqIndex = currentSubseqIndex + 1;
					} else {
						currentSubseqIndex = map.get(c) + 1;
						currentSubseqSize = i - map.get(c);
					}
				}
				map.put(c, i);
			} else {
				map.put(c, i);
				currentSubseqSize = currentSubseqSize + 1;
			}
			if (max < currentSubseqSize) {
				max = currentSubseqSize;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		String input1 = "abcabcbb";
		String input2 = "bbbbb";
		String input3 = "pwwwkew";
		String input4 = "";
		String input5 = "dvdf";

		System.out.println("For input string '" + input1
							+ "' the longest substring is size "
							+ lengthOfLongestSubstring(input1));

		System.out.println("For input string '" + input2
							+ "' the longest substring is size "
							+ lengthOfLongestSubstring(input2));

		System.out.println("For input string '" + input3
							+ "' the longest substring is size "
							+ lengthOfLongestSubstring(input3));

		System.out.println("For input string '" + input4
							+ "' the longest substring is size "
							+ lengthOfLongestSubstring(input4));

		System.out.println("For input string '" + input5
							+ "' the longest substring is size "
							+ lengthOfLongestSubstring(input5));
	}
}
