import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
	/**
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}

		return root;
	}
}

// @lc code=end

/**
 * 
 */
class 二叉树最近的公共祖先 {
	/**
	 * 这种方法非常稳，还是很不错的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(), p = new TreeNode(), q = new TreeNode();
		对数器(root, p, q);
	}

	/**
	 * 使用map，存储所有节点的父节点，然后分别将p和q的父节点链放入set中，如果存在交集就返回最近的公共节点
	 */
	private static TreeNode 对数器(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		Map<TreeNode, TreeNode> father = new HashMap<>();
		father.put(root, null);
		遍历二叉树(father, root);
		// System.out.println(father);
		Set<TreeNode> pset = new HashSet<>();
		pset.add(p);
		TreeNode curp = p;
		while ((curp = father.get(curp)) != null) {
			pset.add(curp);
		}
		TreeNode curq = q;
		if (pset.contains(curq)) {
			return curq;
		}
		while ((curq = father.get(curq)) != null) {
			if (pset.contains(curq)) {
				return curq;
			}
		}
		return null;
	}

	public static void 遍历二叉树(Map<TreeNode, TreeNode> father, TreeNode head) {
		if (head == null) {
			return;
		}
		if (head.left != null) {
			father.put(head.left, head);
			遍历二叉树(father, head.left);
		}
		if (head.right != null) {
			father.put(head.right, head);
			遍历二叉树(father, head.right);
		}
	}
}