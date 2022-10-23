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
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode result = new ListNode();
		ListNode curr = new ListNode();
		int cnt = 0;
		while (head != null && cnt != k) {
			head = head.next;
			cnt++;
		}

		if (cnt < k){
			// 说明k大于链表的长度
			return head;
		}
		打印链表(result);
		return result;
	}

	private void 打印链表(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

	private ListNode 翻转链表(ListNode head, int k) {
		if (head == null) {
			return new ListNode();
		}
		ListNode tail = new ListNode();
		ListNode reverseHead = tail;
		for (int i = 0; i < k; i++) {
			ListNode next = head.next;
			head.next = reverseHead;
			reverseHead = head;
			head = next;
		}
		tail.val = head.val;
		tail.next = head.next;
		return reverseHead;

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

// @lc code=end
