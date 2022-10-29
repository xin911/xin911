import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			// 有问题，是形成不了树的。
			return null;
		}

		// return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length
		// - 1);
		Map<Integer, Integer> valueIndexMap = new HashMap<>();
		valueIndexMap = Arrays.stream(inorder).boxed().collect(Collectors.toMap(k -> k, v -> v));
		for (int i = 0; i < inorder.length; i++) {
			valueIndexMap.put(Integer.valueOf(inorder[i]), Integer.valueOf(i));
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
	}

	public TreeNode buildTree(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
		// 数组胡边界 左树、右树可能为空。 这是最后一部判断的
		if (l1 > r1) {
			return null;
		}

		TreeNode head = new TreeNode(pre[l1]);
		if (l1 == r1) {
			return head;
		}

		int find = l2;
		while (pre[l1] != in[find]) {
			// 使用具现化的例子 赋予具体的值
			// 范围是什么呢
			// 5 6 7 8 9 10 // 先序
			// 0 1 2 3 4 5

			// 13 14 15 5 17 18 // 中序
			// 0 1 2 3 4 5
			// 那么，在先序遍历中的范围，比方说是5
			// 在中序遍历中，表达左树的范围是3个元素
			// l1 + find(3) - l2
			find++;
		}

		head.left = buildTree(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
		head.right = buildTree(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
		return head;
	}

	/**
	 * 在后置变例中，查找元素head的过程，可以使用map进行代替，进行优化。
	 * 
	 * @return
	 */
	public TreeNode buildTree(int[] pre, int l1, int r1, int[] in, int l2, int r2,
			Map<Integer, Integer> valueIndexMap) {
		System.out.println(l1 + "|" + r1 + "  " + l2 + "|" + r2);
		if (l1 > r1) {
			return null;
		}

		TreeNode head = new TreeNode(pre[l1]);
		if (l1 == r1) {
			return head;
		}

		int headIndex = valueIndexMap.get(head.val);
		head.left = buildTree(pre, l1 + 1, l1 + headIndex - l2, in, l2, headIndex - 1, valueIndexMap);
		head.right = buildTree(pre, l1 + headIndex - l2 + 1, r1, in, headIndex + 1, r2, valueIndexMap);
		return head;
	}
}
// @lc code=end
