/*
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */

class FindMinimumInRotatedSortedArrayII {

	public static int findMin(int[] nums) {
		int res = nums[0];

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				res = nums[i + 1];
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("The minimum element in array a0 is " + findMin(a));
	}
}
