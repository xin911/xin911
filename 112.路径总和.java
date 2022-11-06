/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		return 中序遍历求和(0, root, targetSum);
	}

	public boolean 中序遍历求和(int sum, TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (sum + root.val == targetSum && root.left == null && root.right == null) {
			return true;
		}

		// System.out.println(root.val + "|sum: " + sum);
		return 中序遍历求和(sum + root.val, root.left, targetSum) || 中序遍历求和(sum + root.val, root.right, targetSum);
	}
}
// @lc code=end
