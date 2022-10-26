import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start

// Definition for singly-linked list.
// class ListNode {
// 	int val;
// 	ListNode next;

// 	ListNode() {
// 	}

// 	ListNode(int val) {
// 		this.val = val;
// 	}

// 	ListNode(int val, ListNode next) {
// 		this.val = val;
// 		this.next = next;
// 	}
// }

class Solution {
	// k相合并 O(MN)? 208MS
	public ListNode mergeKLists_1(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		if (lists.length < 2) {
			return lists[0];
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

		// 打印节点(result.next);
		return result.next;
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
	public ListNode mergeKLists_2(ListNode[] lists) {
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
	 * 小根堆
	 * 4MS
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
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

	public void 打印节点(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
// @lc code=end
