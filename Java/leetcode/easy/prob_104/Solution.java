package leetcode.easy.prob_104;

import java.util.Stack;

/**
 * easy
 * 104. Maximum Depth of Binary Tree
 * 
 * 이진 트리의 maximum depth 구하기
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if (root == null) {
            return 0;
        }
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = null;

        // ex1
        // root = [3, 9, 20, null, null, 15, 7]
        // ans = 3
        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(sol.maxDepth(root));

        // ex2
        // root = [1, null, 2]
        // ans = 2
        root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(sol.maxDepth(root));
    }
}
