/*
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution.
 */

import java.util.HashMap;

class TwoSum {

    public static void bruteForceSolution(int[] array, int target, int[] ans) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 1; i++) {
                if (target == array[i] + array[j]) {
                    ans[0] = i;
                    ans[1] = j;
                    return;
                }
            }
        }
    }

    public static void hashTableTwoPasses(int[] array, int target, int[] ans) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i],i);
        }
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                ans[0] = i;
                ans[1] = map.get(complement);
                return;
            }
        }
    }

    public static void hashTableOnePass(int[] array, int target, int[] ans) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];

            if (map.containsKey(complement) && map.get(complement) != i) {
                ans[0] = i;
                ans[1] = map.get(complement);
                return;
            }
            map.put(array[i], i);
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int ans0[] = {-1, -1};
        int ans1[] = {-1, -1};
        int ans2[] = {-1, -1};

        bruteForceSolution(nums, target, ans0);
        System.out.println("[" + ans0[0] + "," + ans0[1] + "]");

        hashTableTwoPasses(nums, target, ans1);
        System.out.println("[" + ans1[0] + "," + ans1[1] + "]");

        hashTableOnePass(nums, target, ans2);
        System.out.println("[" + ans2[0] + "," + ans2[1] + "]");
    }
}
