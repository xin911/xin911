import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * deque或者queue都是从左到右的。
 */
public class 双端队列ArrayDeque基本测试 {
	/**
	 * offer方法：内部调用offerLast插入元素，返回插入结果true/false
	 * add方法：内部调用addLast实现
	 * poll方法：内部调用pollFirst实现
	 * remove方法：内部调用removeFirst实现
	 * peek方法：内部调用peekFirst实现
	 * element方法：内部调用getFirst实现
	 * pop方法：内部调用removeFirst实现
	 * push方法：内部调用addFirst实现
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		try {
			// 与peek基本相同
			System.out.println(queue.element()); // null => java.util.NoSuchElementException
		} catch (Exception e) {
			System.err.println("如果queue为空,报错:NoSuchElementException:" + e.getMessage());
		}
		queue.add(null);
		queue.add(100);
		queue.add(200);
		System.out.println(queue);// [null, 100, 200]
		queue.peek();
		System.out.println(queue);// [null, 100, 200]
		System.out.println(queue.remove());// null
		System.out.println(queue);// [100, 200]
		System.out.println("======================");
		Deque<Integer> arrayDeque = new ArrayDeque<>();
		arrayDeque.addFirst(10);
		arrayDeque.addFirst(20);
		arrayDeque.addFirst(30);
		System.out.println(arrayDeque);// [30, 20, 10]
		System.out.println(arrayDeque.poll());
		System.out.println(arrayDeque);// [20, 10]
		arrayDeque.add(40);
		System.out.println(arrayDeque);// [20, 10, 40]
		System.out.println(arrayDeque.pollFirst()); // 20
		System.out.println(arrayDeque); // [10, 40]
		arrayDeque.push(null);
		System.out.println(arrayDeque); // [10, 40]

	}
}
