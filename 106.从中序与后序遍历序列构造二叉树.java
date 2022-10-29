import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}

		Map<Integer, Integer> valueIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			valueIndexMap.put(Integer.valueOf(inorder[i]), Integer.valueOf(i));
		}

		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valueIndexMap);
	}

	public TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2,
			Map<Integer, Integer> valueIndexMap) {

		// System.out.println(l1 + "|" + r1 + " " + l2 + "|" + r2);
		if (l1 > r1 || l2 > r2) {
			return null;
		}

		TreeNode head = new TreeNode(postorder[r2]);
		if (l1 == r1) {
			return head;
		}
		// System.out.println(valueIndexMap.toString());
		int headIndex = valueIndexMap.get(head.val);
		// System.out.println(head.val + "|" + headIndex);
		head.left = buildTree(inorder, l1, headIndex - 1, postorder, l2, l2 + headIndex - l1 - 1, valueIndexMap);
		head.right = buildTree(inorder, headIndex + 1, r1, postorder, l2 + headIndex - l1, r2 - 1, valueIndexMap);
		return head;
	}
}
// @lc code=end
