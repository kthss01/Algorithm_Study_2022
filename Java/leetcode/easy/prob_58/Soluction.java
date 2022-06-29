package leetcode.easy.prob_58;

/**
 * easy
 * 58 Length of Last Word
 * 
 * 마지막 단어의 길이 반환하기
 */
class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s;
        int ans;

        // ex1 
        s = "Hello World";
        ans = 5;
        System.out.println(sol.lengthOfLastWord(s));
        System.out.println(ans);

        // ex2
        s = "   fly me   to   the moon  ";
        ans = 4;
        System.out.println(sol.lengthOfLastWord(s));
        System.out.println(ans);

        // ex3
        s = "luffy is still joyboy";
        ans = 6;
        System.out.println(sol.lengthOfLastWord(s));
        System.out.println(ans);
    }
}