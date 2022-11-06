
/**
 * 给定两个有环或者无环的链表
 * 1、实现一个函数，如果两个链表相交，返回相交的第一个节点如果不相交，返回null
 * 2、如果两个链表的长度之和为N，时间复杂度为O(N)，空间复杂度为O(1)
 * 
 * PS：空间复杂度为O(N)，可以使用容器，HashSet. 进入新的节点时，查询HashSet，如果有，那就是第一个入环节点。
 * 结论：
 * 使用快慢指针。如果有环，那么快慢指针一定会相遇。
 * 在相遇之后，快指针立刻回到head，然后每次走一步，慢指针也每次走一步，这样快慢指针一定会和慢指针在入环节点处相遇。（不要关心证明，这个确实很神奇）
 */
public class 链表的进一步应用 {
	public static void main(String[] args) {
		Node head1 = 生成有环节点(0);
		Node head2 = 生成有环节点(10);
		打印链表节点(head1);
		打印链表节点(head2);
		Node circle1 = 获取入环节点否则空(head1);
		System.out.println("入环的节点1是:" + circle1.val);
		Node circle2 = 获取入环节点否则空(head2);
		System.out.println("入环的节点2是:" + circle2.val);
		head1.next.next.next = head2.next.next.next.next.next;
		返回相交的节点(head1, head2);
	}

	private static Node 返回相交的节点(Node head1, Node head2) {
		// 1、head1无环，head2无环，head1与head2无交集
		// 2、head1无环，head2无环，有交集
		// 结论，head1和head2如果最后一个节点，不是同一个内存节点，那么一定不相交
		// head1.tail != head2.tail那么一定不相交。
		return null;
	}

	/**
	 * 0,1,2,3,4,5,6,7,8,9,
	 * 入环节点为1节点。
	 * 
	 * @param head
	 */
	private static Node 生成有环节点(int start) {
		Node head = new Node(start - 1);
		Node cur = head;
		for (int i = start; i < start + 10; i++) {
			cur.next = new Node(i);
			cur = cur.next;
			if (i == start + 9) {
				cur.next = head.next.next;
			}
		}
		return head;
	}

	/**
	 * 0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2
	 * 
	 * @param head
	 */
	public static void 打印链表节点(Node head) {
		Node cur = head;
		int num = 0;
		while (cur != null && num++ < 30) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
		System.out.println();
	}

	public static Node 获取入环节点否则空(Node head) {
		if (head == null) {
			return null;
		}
		Node fast = head;
		Node slow = head;
		while (fast != null) {
			if (fast.next == null || slow.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}
		fast = head;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}
}
