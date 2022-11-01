import java.util.LinkedList;
import java.util.Stack;

/**
 * 先说结论吧。
 * 测试项目，使用linkedList和数组和arrayList代替stack
 * Stack是先入后出的。
 * 先入栈元素，之后逐个后出的方式出栈。
 * 1、十万次以下，在机器的测试中，都是小于1ms的。所以看不出差距。
 * 1000万次:
 * 2、数组是最快的,只用9ms.
 * Stack使用536ms左右。linkedList使用入栈全部元素，之后队尾删除的方式，用时6000ms(为什么没有想明白)。
 * 
 */
public class 测试stack与linkedList与数组的比较 {
	public static void main(String[] args) {
		int testTime = 10000000;
		Stack<Integer> stack = new Stack<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < testTime; i++) {
			stack.add(i);
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
		System.out.println((System.currentTimeMillis() - start) + "ms, stack");

		start = System.currentTimeMillis();
		// linkedList的stack
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < testTime; i++) {
			linkedList.add(i);
		}
		while (linkedList.size() > 0) {
			linkedList.removeLast();
		}
		System.out.println((System.currentTimeMillis() - start) + "ms, linkedList");

		// 数组的stack
		int index = 0;
		int[] stackint = new int[testTime];
		start = System.currentTimeMillis();
		for (int i = 0; i < testTime; i++) {
			stackint[index++] = i;
		}
		while (index != 0) {
			stackint[--index] = 0;
		}
		System.out.println((System.currentTimeMillis() - start) + "ms, 数组");
	}
}
