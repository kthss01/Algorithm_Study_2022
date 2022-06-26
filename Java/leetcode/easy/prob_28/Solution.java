package leetcode.easy.prob_28;

/**
 * easy
 * Implement strStr()
 * 
 * needle이랑 haystack 문자열 주어질때 haystack에 
 * needle이 있으면 위치 반환 없으면 -1 반환
 * 
 * constraints
 *  1 <= haystack.length, needle.length <= 10^4
 *  haystack, needle only lowercase English
 */
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String haystack, needle;

        // ex1
        haystack = "hello";
        needle = "ll";
        System.out.println(sol.strStr(haystack, needle));

        // ex2
        haystack = "aaaaa";
        needle = "bba";
        System.out.println(sol.strStr(haystack, needle));
    }
}