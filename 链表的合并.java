public class 链表的合并 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4, new ListNode(5));
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3, new ListNode(4));
		ListNode l3 = new ListNode(1, new ListNode(6));
		ListNode[] para = new ListNode[] { l1, l2, l3 };
		// k相合并链表(para);
		mergeKLists(para);
	}

	// k相合并
	public static ListNode k相合并链表(ListNode[] lists) {
		ListNode minHead = new ListNode();
		if (lists == null || lists.length < 2) {
			return minHead;
		}

		int minPoint = 0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				continue;
			}
			// 获取最小的节点
			if (lists[minPoint].val > lists[i].val) {
				minPoint = i;
				continue;
			}
		}
		minHead.next = lists[minPoint];
		lists[minPoint] = lists[minPoint].next;

		打印节点(lists[minPoint]);
		return minHead.next;
	}

	public static void 打印节点(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

	/**
	 * 作者：sweetiee
	 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * 
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while (true) {
			ListNode minNode = null;
			int minPointer = -1;
			for (int i = 0; i < k; i++) {
				if (lists[i] == null) {
					continue;
				}
				if (minNode == null || lists[i].val < minNode.val) {
					minNode = lists[i];
					minPointer = i;
				}
			}
			if (minPointer == -1) {
				break;
			}
			tail.next = minNode;
			tail = tail.next;
			lists[minPointer] = lists[minPointer].next;
		}
		return dummyHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}