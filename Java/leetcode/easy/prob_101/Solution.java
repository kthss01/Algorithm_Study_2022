package leetcode.easy.prob_101;

/**
 * easy
 * 101. Symmetric Tree
 * 
 * 이진 트리가 주어질 때
 * 스스로 mirror 인지 확인 
 *  가운데를 중심으로 서로 뒤집혀있는지 확인
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
    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = null;

        // ex1
        // root = [1,2,2,3,4,4,3]
        // true
        root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(2), null),
                new TreeNode(3, null, new TreeNode(3)));
        System.out.println(sol.isSymmetric(root));

        // ex2
        // root = [1,2,2,null,3,null,3]
        // false
        root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(2), null),
                new TreeNode(3, null, new TreeNode(3)));
        System.out.println(sol.isSymmetric(root));
    }
}
