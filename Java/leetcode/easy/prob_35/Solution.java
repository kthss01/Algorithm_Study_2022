package leetcode.easy.prob_35;

import java.util.Arrays;

/**
 * easy 
 * 35 Search Insert Position
 * 
 * 중복된 숫자가 없는 정렬된 배열이 주어질 때
 * target value가 있으면 index 반환 없으면
 * insert 해서 index 반환 
 * 
 * O(log n) 이 되도록 구현 (binary search 말한듯)
 */
public class Solution {
    // public int searchInsert(int[] nums, int target) {
    //     int left = 0;
    //     int right = nums.length - 1;

    //     while (left <= right) {
    //         if (target <= nums[left]) {
    //             return left;
    //         } else if (target > nums[right]) {
    //             return right + 1;
    //         }
    //         int mid = left + (right - left) / 2;
    //         if (target == nums[mid]) {
    //             return mid;
    //         } else if (target < nums[mid]) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }

    //     return -1;
    // }

    // better
    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if (result < 0) {
            result = Math.abs(result) - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums;
        int target;

        // test
        nums = new int[] {1, 3, 5, 6};
        target = 2;
        System.out.println(sol.searchInsert(nums, target));

        // ex1
        nums = new int[] {1, 3, 5, 6};
        target = 5;
        System.out.println(sol.searchInsert(nums, target));

        // ex2
        nums = new int[] {1, 3, 5, 6};
        target = 2;
        System.out.println(sol.searchInsert(nums, target));

        // ex3
        nums = new int[] {1, 3, 5, 6};
        target = 7;
        System.out.println(sol.searchInsert(nums, target));
    }
}
