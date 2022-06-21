package leetcode.easy.prob_26;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * easy
 * 26. Remove Duplicates from Sorted Array
 * 
 * 중복 제거 후 열의 갯수 출력하고
 * 똑같은 크기의 배열을 출력하되 중복되지 않은 요소만 먼저 위치 
 * 후에 남은건 상관없음 _로 표시해도됨
 * 
 * Constraints
 *  1 <= nums.length <= 3 * 10^4
 *  -100 <= nums[i] <= 100
 *  nums is sorted in non-decreasing order
 */
public class Solution {
    // public int removeDuplicates(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (Integer num : nums) {
    //         set.add(num);
    //     }

    //     int size = nums.length;
    //     //nums = new int[size];
    //     int i = 0;
    //     for (Integer num : set) {
    //         nums[i++] = num;
    //     }

    //     Arrays.sort(nums, 0, i);

    //     while (i < size) {
    //         nums[i++] = -1;
    //     }

    //     return set.size();
    // }

    // better
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums;
        int k;

        // ex1
        nums = new int[] {1, 1, 2};
        k = sol.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
        
        // ex2 
        nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = sol.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

        // test
        nums = new int[] {-3,-1,0,0,0,3,3};
        k = sol.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
