import java.util.Queue;

/**
 * 1、二叉树的先序遍历node节点的前半部分，与二叉树后序遍历node节点的后半部分，求交集，就是node节点的祖先
 * abdetcxksg
 * dtebksxgca
 */
public class 二叉树递归序列化反序列化的应用 {
	public static void main(String[] args) {
		使用非递归的方式实现先序遍历();
	}

	private static void 使用非递归的方式实现先序遍历() {
		// 使用双Stack或者双Queue
	}

	/**
	 * 1、先序遍历的序列化是可行的，
	 * 2、中序遍历的序列化是有歧义的，所以中序遍历的序列化是不行的（所以反序列化也是不行的）
	 * 先序和后序遍历无此问题。
	 * 例如：
	 * 2
	 * /\
	 * 1
	 * /\
	 * 与
	 * 1
	 * /\
	 * 空 2
	 * /\
	 * 利用队列或者栈
	 */
	private static void 二叉树的序列化(TreeNode head, Queue<Integer> queue) {
		if (head == null) {
			return;
		}

		queue.add(Integer.valueOf(head.val));
		二叉树的序列化(head.left, queue);
		二叉树的序列化(head.right, queue);
	}

	/**
	 * 利用队列或者栈
	 */
	private static TreeNode 二叉树的反序列化(Queue<Integer> queue) {
		Integer headVal = queue.poll();
		if (headVal == null) {
			return null;
		}

		TreeNode head = new TreeNode(headVal.intValue());
		head.left = 二叉树的反序列化(queue);
		head.right = 二叉树的反序列化(queue);
		return head;
	}
}
