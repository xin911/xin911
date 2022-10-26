import java.util.PriorityQueue;
import java.util.Queue;

public class 链表的合并 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4, new ListNode(5));
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3, new ListNode(4));
		ListNode l3 = new ListNode(1, new ListNode(6));
		ListNode[] para = new ListNode[] { l1, l2, l3 };
		k相合并链表(para);
		// mergeKLists(para);
	}

	// k相合并 208MS
	public static ListNode k相合并链表(ListNode[] lists) {
		if (lists == null || lists.length < 2) {
			return null;
		}
		ListNode result = new ListNode();
		ListNode tail = result;
		while (true) {
			int minPoint = 0;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					continue;
				}

				if (lists[minPoint] == null) {
					minPoint = i;
					continue;
				}
				// 获取最小的节点
				if (lists[minPoint].val > lists[i].val) {
					minPoint = i;
				}
			}
			if (lists[minPoint] == null) {
				break;
			}

			tail.next = lists[minPoint];
			tail = tail.next;

			lists[minPoint] = lists[minPoint].next;

		}

		打印节点(result.next);
		return result.next;
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
	 * 208MS
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

	/**
	 * 4ms
	 * 时间复杂度：考虑优先队列中的元素不超过 kk 个，那么插入和删除的时间代价为 O(\log k)O(logk)，这里最多有 knkn
	 * 个点，对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 O(kn \times \log k)O(kn×logk)。
	 * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 kk 个，故渐进空间复杂度为 O(k)O(k)。
	 * 
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode 小根堆(ListNode[] lists) {
		Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
		for (ListNode node : lists) {
			if (node != null) {
				pq.offer(node);
			}
		}

		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while (!pq.isEmpty()) {
			ListNode minNode = pq.poll();
			tail.next = minNode;
			tail = minNode;
			if (minNode.next != null) {
				pq.offer(minNode.next);
			}
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