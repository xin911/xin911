import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
class Solution {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 二叉树最大宽度(root);
	}

}

// @lc code=end
class 二叉树最大宽度 {
	public static void main(String[] args) {
		// 示例1
		TreeNode 示例1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3, null, null)),
				new TreeNode(2, null, new TreeNode(9)));
		System.out.println(二叉树节点宽度(示例1));
		// 示例2
		TreeNode 示例2 = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
				new TreeNode(2, null, new TreeNode(9, new TreeNode(7, null, null), null)));

		// 示例3
		TreeNode 示例3 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
		
		return;
	}

	/**
	 * 使用两个队列就可以处理。如果使用一个双端队列，也可以吧
	 * 
	 * @param head
	 * @return
	 */
	public static int 二叉树节点宽度(TreeNode head) {
		if (head == null) {
			return 0;
		}
		// ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		linkedList.add(head);
		TreeNode curEnd = head;
		TreeNode nextEnd = null;
		int max = linkedList.size();
		int cnt = 0;
		while (!linkedList.isEmpty()) {
			TreeNode cur = linkedList.poll();
			if (cur.left != null) {
				linkedList.add(cur.left);
				nextEnd = cur.left;
			}
			if (cur.right != null) {
				linkedList.add(cur.right);
				nextEnd = cur.right;
			}
			cnt++;
			if (cur == curEnd) {
				curEnd = nextEnd;
				max = Math.max(max, cnt);
				cnt = 0;
			}
		}
		return max;
	}
}