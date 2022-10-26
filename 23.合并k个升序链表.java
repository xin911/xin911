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
	// k相合并
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode minHead = new ListNode();
		if (lists == null || lists.length < 2) {
			return minHead;
		}

		minHead = lists[0];
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

	public void 打印节点(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
// @lc code=end
