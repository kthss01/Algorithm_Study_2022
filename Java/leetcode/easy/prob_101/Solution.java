package leetcode.easy.prob_101;

import java.util.Stack;

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
    // public boolean isSymmetric(TreeNode root) {
    // return root == null || isSymmetricHelp(root.left, root.right);
    // }

    // private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
    // if (left == null || right == null) {
    // return left == right;
    // }
    // if (left.val != right.val) {
    // return false;
    // }
    // return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right,
    // right.left);
    // }

    // non recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!stack.empty()) {
            if (stack.size() % 2 != 0) {
                return false;
            }

            right = stack.pop();
            left = stack.pop();

            if (right.val != left.val) {
                return false;
            }

            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = null;

        // ex1
        // root = [1,2,2,3,4,4,3]
        // true
        root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(sol.isSymmetric(root));

        // ex2
        // root = [1,2,2,null,3,null,3]
        // false
        root = new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        System.out.println(sol.isSymmetric(root));
    }
}
