/*
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 */

class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int res = nums.length >= 1 ? 1 : 0;   // Array new length
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                if (i - index > 1) {
                    nums[index + 1] = nums[i];
                }
                res++;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a0 = {};
        int[] a1 = {1};
        int[] a2 = {1,1,2};
        int[] a3 = {1,2,3};
        int[] a4 = {1,1,1,2,2,2,3};
        int[] a5 = {1,1,1,1,1,1,1};
        int res = 0;

        res = removeDuplicates(a0);
        System.out.println("a0: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a0[i]);
        }

        res = removeDuplicates(a1);
        System.out.println("a1: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a1[i]);
        }

        res = removeDuplicates(a2);
        System.out.println("a2: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a2[i]);
        }

        res = removeDuplicates(a3);
        System.out.println("a3: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a3[i]);
        }

        res = removeDuplicates(a4);
        System.out.println("a4: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a4[i]);
        }

        res = removeDuplicates(a5);
        System.out.println("a5: The new array length is " + res);
        for (int i = 0; i < res; i++) {
            System.out.println("a[" + i + "] = " + a5[i]);
        }
    }
}
