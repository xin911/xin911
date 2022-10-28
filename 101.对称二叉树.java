
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
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
class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}

		TreeNode left = root;
		TreeNode right = root;
		return isSymmetric(left, right);
	}

	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) {
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}
}
