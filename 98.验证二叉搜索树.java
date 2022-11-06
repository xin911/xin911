/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
	/**
	 * 5
	 * 3 7
	 * 14 69
	 * null 2 null null null null 8 null
	 * 二叉搜索树的特性：
	 * 中序遍历一定是递增的。对啊，左->头->右
	 * 1、整棵树的左树是二叉搜索树
	 * 2、整棵树的右树是二叉搜索树
	 * 3、左树的最大值<右树的最小值
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return 是否是二叉搜索树(root).isValidBST;
	}

	public Treeinfo 是否是二叉搜索树(TreeNode head) {
		if (head == null) {
			return null;
		}

		Treeinfo left = 是否是二叉搜索树(head.left);
		Treeinfo right = 是否是二叉搜索树(head.right);
		int min = head.val;
		int max = head.val;
		if (left != null) {
			min = Math.min(min, left.min);
			max = Math.max(max, left.max);
			System.out.println(left.toString() + "|head:" + head.val + "|left:" + head.left);
		}
		if (right != null) {
			min = Math.min(min, right.min);
			max = Math.max(max, right.max);
			System.out.println(right.toString() + "|head:" + head.val + "|right:" + head.right);
		}

		// boolean isValidBST = true;
		// if (left != null && !left.isValidBST) {
		// isValidBST = false;
		// }
		// if (right != null && !right.isValidBST) {
		// isValidBST = false;
		// }

		// boolean isLeftLess = left == null ? true : left.max < head.val;
		// boolean isRightMore = right == null ? true : right.min > head.val;
		// if (!isLeftLess || !isRightMore) {
		// isValidBST = false;
		// }
		boolean isValidBST = false;
		if ((left == null ? true
				: (left.isValidBST && left.max < head.val))
				&& (right == null ? true
						: (right.isValidBST && head.val < right.min))) {
			isValidBST = !isValidBST;
		}
		return new Treeinfo(min, max, isValidBST);
	}
}

class Treeinfo {
	int min;
	int max;
	boolean isValidBST;

	public Treeinfo(int min, int max, boolean isValidBST) {
		this.min = min;
		this.max = max;
		this.isValidBST = isValidBST;
	}

	@Override
	public String toString() {
		return String.format("min:%4d, max:%4d, %s", min, max, isValidBST);
	}
}
// @lc code=end
