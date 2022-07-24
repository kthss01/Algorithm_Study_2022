package leetcode.easy.prob_100;

/**
 * easy
 * 100. Same Tree
 * 
 * 두 개의 이진 트리가 주어질 때 (p, q) 같은지 체크
 * 같으면 true 다르면 false
 * 
 * Constraints
 *  노드의 수 0 ~ 100
 *  노드 값 -10^4 ~ 10^4
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode p = null;
        TreeNode q = null;

        // ex1
        // p = [1, 2, 3] q = [1, 2, 3]
        // true
        p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sol.isSameTree(p, q));

        // ex2
        // p = [1, 2] q = [1, null, 2]
        // false
        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(sol.isSameTree(p, q));

        // ex3
        // p = [1, 2, 1] q = [1, 1, 2]
        // false
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(sol.isSameTree(p, q));
    }
}
