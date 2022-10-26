import java.util.Comparator;
import java.util.PriorityQueue;

public class 比较器 {
	public static void main(String[] args) {
		System.out.println(~12345);
		/**
		 * 优先队列，内部实际上用的是小根堆
		 */
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> ~(o1 - o2));
		heap.add(11);
		heap.add(12);
		heap.add(14);
		heap.add(13);
		System.out.println(heap.peek());
		System.out.println(heap.poll());
		while (!heap.isEmpty()) {
			System.out.println(heap.poll());
		}

		// compareTo是字典顺序

	}
}
