package leetcode.easy.prob_66;

import java.util.Arrays;

/**
 * easy
 * 66. Plus One
 * 
 * digits 배열로 주어질 때 
 * 이 숫자 + 1 하기
 * 0으로 시작안함
 * 
 * Constraints
 *  1 <= digits.length <= 100
 *  0 <= digits[i] <= 9
 *  not leading 0
 */
public class Solution {
    // public int[] plusOne(int[] digits) {
    //     long num = sumArr(digits);
    //     num++;
    //     return makeArr(num);
    // }

    // public long sumArr(int[] digits) {
    //     long num = 0;
    //     boolean isMinus = false;
    //     for (int i = 0; i < digits.length; i++) {
    //         int p = digits.length - i - 1;
    //         if (p == 0 && digits[p] < 0) {
    //             isMinus = true;    
    //         }
    //         num += Math.abs(digits[p]) * Math.pow(10, i);
    //     }
    //     num = isMinus ? num * -1 : num;
    //     return num;
    // }

    // public int[] makeArr(long num) {
    //     String str = String.valueOf(num);
    //     int[] arr = new int[str.length()];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = str.charAt(i) - '0';
    //     }
    //     return arr;
    // }

    // public int[] plusOne(int[] digits) {
    //     int[] temp = Arrays.copyOf(digits, digits.length);
    //     temp[temp.length - 1]++;
    //     int i = temp.length - 1;
    //     boolean isNew = false;
    //     while (i >= 0 && temp[i] == 10) {
    //         if (i != 0) {
    //             temp[i - 1]++;
    //         } else {
    //             isNew = true;
    //         }
    //         temp[i] -= 10;
    //         i--;
    //     }
        
    //     int[] result = temp;
    //     if (isNew) {
    //         result = new int[temp.length + 1];
    //         result[0] = 1;
    //         for (int j = 0; j < temp.length; j++) {
    //             result[j + 1] = temp[j];
    //         }
    //     }

    //     return result;
    // }

    // more simple
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 이 경우 말곤 없음
        int[] newDigits = new int[n + 1];
        // 처리도 필요 없음
        newDigits[0] = 1;

        return newDigits;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] digits;
        int[] ans;

        // ex1
        digits = new int[] {1, 2, 3};
        ans = new int[] {1, 2, 4};
        //System.out.println(Arrays.toString(sol.plusOne(digits)));
        System.out.println(Arrays.toString(ans));

        // ex2
        digits = new int[] {4, 3, 2, 1};
        ans = new int[] {4, 3, 2, 2};
        //System.out.println(Arrays.toString(sol.plusOne(digits)));
        System.out.println(Arrays.toString(ans));

        // ex3
        digits = new int[] {9};
        ans = new int[] {1, 0};
        System.out.println(Arrays.toString(sol.plusOne(digits)));
        System.out.println(Arrays.toString(ans));

        // prob
        digits = new int[] {9,8,7,6,5,4,3,2,1,0};
        ans = new int[] {9,8,7,6,5,4,3,2,1,1};
        System.out.println(Arrays.toString(sol.plusOne(digits)));
        System.out.println(Arrays.toString(ans));
    }
}
