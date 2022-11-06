
/**
 * 号称是单链表胡爹题：
 * 
 * 给定两个有环或者无环的链表
 * 1、实现一个函数，如果两个链表相交，返回相交的第一个节点如果不相交，返回null
 * 2、如果两个链表的长度之和为N，时间复杂度为O(N)，空间复杂度为O(1)
 * 
 * PS：空间复杂度为O(N)，可以使用容器，HashSet. 进入新的节点时，查询HashSet，如果有，那就是第一个入环节点。
 * 结论：
 * 使用快慢指针。如果有环，那么快慢指针一定会相遇。
 * 在相遇之后，快指针立刻回到head，然后每次走一步，慢指针也每次走一步，这样快慢指针一定会和慢指针在入环节点处相遇。（不要关心证明，这个确实很神奇）
 * 
 * 3、如果一个链表有环，一个链表无环，两者不可能相交。
 * 
 * 
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
		返回无环相交的节点(生成无环节点(20), 生成无环节点(30));
		// 有环与无环，必然不相交
		// 两个有环情况，进行分析，一共三种场景情况
		// 1、不相交
		// 2、相交，
		// a、相同的入环节点
		// b、不相同的入环节点
		返回双环链表的相交节点();

		最终版(head1, head2);
	}

	public static Node 最终版(Node head1, Node head2) {
		// 都为空 不相交
		if (head1 == null || head2 == null) {
			return null;
		}

		Node loop1 = 获取入环节点否则空(head1);
		Node loop2 = 获取入环节点否则空(head2);

		if (loop1 == null && loop2 == null) {
			// 都不是环
			return 无环相交的节点(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			// 都有环
			return 返回双环链表相同的相交节点(head1, loop1, head2, loop2);
		}
		// 一种有环，一种无环的情况，注定不相交
		return null;
	}

	private static Node 返回双环链表的相交节点() {
		// 1、拥有相同的环
		Node head1 = 生成有环节点(1); // 0 1 2为有环节点
		Node loop1 = head1.next.next;
		Node head2 = 生成有环节点(11); // 10 11 12为有环节点
		head2.next = head1.next;
		Node loop2 = head2.next.next;
		打印链表节点(head1);
		System.out.println("loop1: " + loop1.val);
		打印链表节点(head2);
		System.out.println("loop2: " + loop2.val);

		return 返回双环链表相同的相交节点(head1, loop1, head2, loop2);
	}

	private static Node 返回双环链表相同的相交节点(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2) {
			int cnt1 = 0;
			Node cur1 = head1;
			while (cur1 != null && cur1 != loop1) {
				cur1 = cur1.next;
				cnt1++;
			}
			int cnt2 = 0;
			Node cur2 = head2;
			while (cur2 != null && cur2 != loop2) {
				cur2 = cur2.next;
				cnt2++;
			}

			Node longnode = cnt1 >= cnt2 ? head1 : head2;
			Node shortnode = cnt1 >= cnt2 ? head2 : head1;
			for (int i = 0; i < Math.abs(cnt1 - cnt2); i++) {
				longnode = longnode.next;
			}
			while (longnode != shortnode) {
				longnode = longnode.next;
				shortnode = shortnode.next;
			}
			System.out.println("--->返回双环链表相同的相交节点:" + shortnode.val);
			return shortnode;
		} else {
			// 双环链表环内相交的场景
			while (loop1.next != loop1) {
				loop1 = loop1.next;
				if (loop1 == loop2) {
					return loop1;
				}
			}
			// 不相交胡场景
			return null;
		}
	}

	private static Node 返回无环相交的节点(Node head1, Node head2) {
		// 1、head1无环，head2无环，head1与head2无交集
		// 2、head1无环，head2无环，有交集
		// 结论，head1和head2如果最后一个节点，不是同一个内存节点，那么一定不相交
		// head1.tail != head2.tail那么一定不相交。
		System.out.println("===========返回无环相交的节点===========");
		打印链表节点(head1);
		打印链表节点(head2);

		// 设置无环相交的节点
		head1.next.next.next = head2.next.next.next.next.next;
		打印链表节点(head1);
		打印链表节点(head2);
		System.out.println("无环相交的节点是:" + head1.next.next.next.val);

		return 无环相交的节点(head1, head2);
	}

	private static Node 无环相交的节点(Node head1, Node head2) {
		// 计算逻辑
		// 因为无环
		// 先判断是否相交
		int cnt1 = 0;
		if (head1 == null || head2 == null) {
			return null;
		}
		Node tail1 = head1;
		Node tail2 = head2;
		while (tail1.next != null) {
			tail1 = tail1.next;
			cnt1++;
		}
		int cnt2 = 0;
		while (tail2.next != null) {
			tail2 = tail2.next;
			cnt2++;
		}
		if (tail1 != tail2) {
			return null;
		}

		Node longhead = cnt1 >= cnt2 ? head1 : head2;
		Node shorthead = cnt1 >= cnt2 ? head2 : head1;
		for (int i = 0; i < Math.abs(cnt1 - cnt2); i++) {
			longhead = longhead.next;
		}
		while (longhead != shorthead) {
			longhead = longhead.next;
			shorthead = shorthead.next;
		}

		System.out.println("无环相交的节点: " + longhead.val);
		return longhead;
	}

	/**
	 * 0,1,2,3,4,5,6,7,8,9,
	 * 入环节点为1节点。
	 * 
	 * @param head
	 */
	private static Node 生成有环节点(int start) {
		return 生成节点(start, true);
	}

	/**
	 * 0,1,2,3,4,5,6,7,8,9,
	 * 
	 * @param head
	 */
	private static Node 生成无环节点(int start) {
		return 生成节点(start, false);
	}

	private static Node 生成节点(int start, boolean isCircle) {
		Node head = new Node(start - 1);
		Node cur = head;
		for (int i = start; i < start + 10; i++) {
			cur.next = new Node(i);
			cur = cur.next;
			if (i == start + 9 && isCircle) {
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
