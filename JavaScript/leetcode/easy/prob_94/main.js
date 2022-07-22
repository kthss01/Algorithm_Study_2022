/**
 * easy
 * 94. Binary Tree Inorder Traversal
 *
 * root binary tree 주어질 때
 * inorder 중위 순회 하기
 *  preorder 전위
 *  postorder 후위
 *
 * Constraints
 *  tree 0 ~ 100
 *  Node.val -100 ~ 100
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

// 아래 방식으로 변환 가능
// function TreeNode(val, left, right) {
// 	this.val = val === undefined ? 0 : val;
// 	this.left = left === undefined ? null : left;
// 	this.right = right === undefined ? null : right;
// }

class TreeNode {
	constructor(val, left, right) {
		this.val = val === undefined ? 0 : val;
		this.left = left === undefined ? null : left;
		this.right = right === undefined ? null : right;
	}
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
const inorderTraversal = function (root) {
	const result = [];
	const stack = [];

	// 이렇게하면 pop이 한번 더되는거 같음
	// if (root) {
	// 	stack.push(root);
	// }

	// while (stack.length != 0) {
	// 	const node = stack.pop();

	// 	if (node.left) {
	// 		stack.push(node.left);
	// 		continue;
	// 	}
	// 	result.push(node.val);
	// 	if (node.right) {
	// 		stack.push(node.right);
	// 		continue;
	// 	}
	// }

	// solution
	let cur = root;

	while (cur || stack.length !== 0) {
		if (cur) {
			stack.push(cur);
			cur = cur.left;
		} else {
			cur = stack.pop();
			result.push(cur.val);
			cur = cur.right;
		}
	}

	return result;
};

let root;
let ans = [];

// ex1
root = [1, null, 2, 3];
root = new TreeNode(
	1,
	null,
	new TreeNode(2, new TreeNode(3, null, null), null)
);
ans = [1, 3, 2];
console.log(inorderTraversal(root), ans);

// ex2
root = [];
root = null;
ans = [];
console.log(inorderTraversal(root), ans);

// ex3
root = [1];
root = new TreeNode(1, null, null);
ans = [1];
console.log(inorderTraversal(root), ans);
