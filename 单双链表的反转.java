public class 单双链表的反转 {
	public static void main(String[] args) {
		Node head = new Node(1);
		递归创建节点(head, 1, 9);
		打印单链表节点(head);
		Node node = 循环创建节点(8);
		Node reverseHead = 链表逆序(node);
		打印单链表节点(reverseHead);
		int a = 1;
		int b = 2;
		int c = 3;
		System.out.println(c = b = a);
		Node kHead = 链表k逆序(head, 3);
		打印单链表节点(kHead);

	}

	private static Node 链表k逆序(Node head, int k) {
		Node tail = new Node(0);
		Node kHead = tail;
		Node next = null;
		while (k-- > 0) {
			next = head.next;
			head.next = kHead;
			kHead = head;
			head = next;
		}
		// tail.val = head.val;
		// tail.next = head.next;
		打印单链表节点(kHead);
		打印单链表节点(head);
		return kHead;
	}

	private static Node 链表逆序(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			打印单链表节点(pre);
		}
		return pre;
	}

	private static DoubleNode 双向链表逆序(DoubleNode head) {
		DoubleNode next = null;
		DoubleNode pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		return null;
	}

	private static void 打印单链表节点(Node node) {
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println();
	}

	/**
	 * 
	 * @param 当前节点
	 * @param 当前节点数值
	 * @param 链表长度
	 * @return
	 */
	private static void 递归创建节点(Node 当前节点, int 当前节点数值, int 链表长度) {
		if (当前节点数值 >= 链表长度) {
			return;
		}
		当前节点.next = new Node(++当前节点数值);
		递归创建节点(当前节点.next, 当前节点数值, 链表长度);
	}

	private static Node 循环创建节点(int 链表长度) {
		Node head = new Node(1);
		Node cur = head;
		for (int i = 2; i < 链表长度 + 1; i++) {
			cur.next = new Node(i);
			cur = cur.next;
		}
		打印单链表节点(head);
		return head;
	}
}

class Node {
	int val;
	Node next;

	/**
	 * @param val
	 */
	public Node(int val) {
		this.val = val;
	}
}

class DoubleNode {
	int val;
	DoubleNode next;
	DoubleNode pre;

	/**
	 * @param val
	 */
	public DoubleNode(int val) {
		this.val = val;
	}
}