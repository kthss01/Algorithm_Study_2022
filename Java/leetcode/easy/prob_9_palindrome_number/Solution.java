package leetcode.easy.prob_9_palindrome_number;

/**
 * Easy
 * Palindrome Number
 * 
 * palindrome 
 *  121 - O
 *  123 - X
 */
class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int x;
        boolean ans;

        // ex1
        x = 121;
        ans = true;
        System.out.println("compute : " + sol.isPalindrome(x));
        System.out.println("ans : " + ans);
        System.out.println("result : " 
                + (sol.isPalindrome(x) == ans ? "true" : "false"));

        // ex2
        x = -121;
        ans = false;
        System.out.println("compute : " + sol.isPalindrome(x));
        System.out.println("ans : " + ans);
        System.out.println("result : " 
                + (sol.isPalindrome(x) == ans ? "true" : "false"));

        // ex3
        x = 10;
        ans = false;
        System.out.println("compute : " + sol.isPalindrome(x));
        System.out.println("ans : " + ans);
        System.out.println("result : " 
                + (sol.isPalindrome(x) == ans ? "true" : "false"));

    }
}