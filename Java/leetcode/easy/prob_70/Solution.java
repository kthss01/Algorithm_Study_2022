package leetcode.easy.prob_70;

/**
 * easy 
 * 70. Climbing Stairs
 * 
 * n steps reach the top
 * 1 or 2로 climb 가능
 * 가능한 경우수는 몇개나 되는지
 * 
 * Constraints
 *  1 <= n <= 45
 */
class Solution {
    public int climbStairs(int n) {
        // dp 
        // 현재 가능한 경우의 수
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n;
        int ans;

        // ex1
        n = 2;
        ans = 2;
        System.out.println(ans);
        System.out.println(sol.climbStairs(n));

        // ex2
        n = 3;
        ans = 3;
        System.out.println(ans);
        System.out.println(sol.climbStairs(n));
    }
}