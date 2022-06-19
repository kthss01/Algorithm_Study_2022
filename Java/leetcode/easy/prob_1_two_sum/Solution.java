package leetcode.easy.prob_1_two_sum;

import java.util.Arrays;

/**
 * Easy
 * Two Sum
 * array nums 
 * int target
 * 
 * array 중 2 값을 더해서 target이 되면 그 2개의 index 반환
 * 
 * constraints
 *  2 <= nums.length <= 10^4
 *  -10^9 <= nums[i] <= 10^9
 *  -10^9 <= target <= 10^9
 *  only one valid answer exists
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = null;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int num1 = nums[i];
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    return new int[] {i, j};
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums;
        int target;
        int[] ans;

        // ex1 {0, 1}
        nums = new int[] {2, 7, 11, 15};
        target = 9;
        ans = new int[] {0, 1};
        System.out.println("result: " + Arrays.toString(sol.twoSum(nums, target)));
        System.out.println("ans: " + Arrays.equals(sol.twoSum(nums, target), ans));

        // ex2 {1, 2}
        nums = new int[] {3, 2, 4};
        target = 6;
        ans = new int[] {1, 2};
        System.out.println("result: " + Arrays.toString(sol.twoSum(nums, target)));
        System.out.println("ans: " + Arrays.equals(sol.twoSum(nums, target), ans));

        // ex3 {0, 1}
        nums = new int[] {3, 3};
        target = 6;
        ans = new int[] {0, 1};
        System.out.println("result: " + Arrays.toString(sol.twoSum(nums, target)));
        System.out.println("ans: " + Arrays.equals(sol.twoSum(nums, target), ans));
    }
}