/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		return 二叉树的最近公共祖先(root, p, q);
	}

	public TreeNode 二叉树的最近公共祖先(TreeNode head, TreeNode p, TreeNode q) {
		if (head == null || head == p || head == q) {
			return head;
		}
		TreeNode left = 二叉树的最近公共祖先(head.left, p, q);
		TreeNode right = 二叉树的最近公共祖先(head.right, p, q);
		if (left != null && right != null) {
			return head;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
}
// @lc code=end

class 二叉树最近公共祖先的测试 {

	
	public TreeNode 二叉树的最近公共祖先(TreeNode head, TreeNode pq) {
		if (head == null) {
			return null;
		}
		if (head == pq) {
			return head;
		}
		TreeNode left = 二叉树的最近公共祖先(head.left, pq);
		TreeNode right = 二叉树的最近公共祖先(head.right, pq);
		if (left != null && right != null) {
			return head;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;

	}
}