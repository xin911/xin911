import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> results = new ArrayList<>();
		// 先序遍历(root);
		results = 层序遍历(root);
		return results;
	}

	public void 先序遍历(TreeNode head) {
		if (head == null) {
			return;
		}
		// Queue<TreeNode> queue = new LinkedList<>();
		// queue.add(head);
		// while (queue != null) {
		// result.add(queue.poll().val);
		// }
		System.out.println(head.val);
		先序遍历(head.left);
		先序遍历(head.right);
	}

	public List<List<Integer>> 层序遍历(TreeNode head) {
		if (head == null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		if (head.left != null) {
			queue.add(head.left);
		}
		if (head.right != null) {
			queue.add(head.right);
		}
		queue.add(head);
		while (queue != null) {
			result.add(queue.poll().val);
		}

	}
}
// @lc code=end
