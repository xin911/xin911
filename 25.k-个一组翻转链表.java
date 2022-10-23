/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	/**
	 * 递归子链表
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// 打印链表(head);
		ListNode curr = head;
		int cnt = 0;
		// 1->2->3->4->5->6->7->8->null
		while (curr != null && cnt != k) {
			curr = curr.next;
			cnt++;
		}
		if (cnt < k) {
			return head;
		}
		// 4->5->6->7->8->null
		curr = reverseKGroup(curr, k);
		ListNode result = 翻转链表(head, k, curr);
		// 打印链表(result);
		return result;
	}

	private ListNode 翻转链表(ListNode head, int k, ListNode curr) {
		ListNode next = null;
		while (k-- > 0) {
			next = head.next;
			head.next = curr;
			curr = head;
			head = next;
		}
		return curr;
	}

	private void 打印链表(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}
}

// class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

// @lc code=end
