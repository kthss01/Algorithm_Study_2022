package leetcode.easy.prob_108;

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

/**
 * easy
 * 108. Convert Sorted Array to Binary Search Tree
 * 오름차순의 배열이 주어질 때
 * 높이 균등인 이진 탐색 트리 만들기
 * hight-balanced는 서브트리의 depth가 같거나 하나 더 큰 걸 말함
 * hight-balanced binary search tree - 균형 이진 탐색 트리 BST
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = null;
        TreeNode tree = null;

        // ex1
        // nums = [-10, -3, 0, 5, 9]
        // ans = [0, -3, 9, -10, null, 5]
        nums = new int[] { -10, -3, 0, 5, 9 };
        tree = sol.sortedArrayToBST(nums);
        // tree = new TreeNode(0, new TreeNode(-3, new TreeNode(-10), null), new
        // TreeNode(9, new TreeNode(5), null));
        System.out.println("[" + sol.printTree(tree) + "]");

        // ex2
        // nums = [1, 3]
        // ans = [3, 1]
        nums = new int[] { 1, 3 };
        tree = sol.sortedArrayToBST(nums);
        System.out.println("[" + sol.printTree(tree) + "]");
    }

    private String printTree(TreeNode tree) {
        if (tree == null) {
            return "null";
        }
        String str = "";

        str += String.valueOf(tree.val);
        if (tree.left != null || tree.right != null) {
            str += " " + printTree(tree.left);
            str += " " + printTree(tree.right);
        }

        return str;
    }
}
