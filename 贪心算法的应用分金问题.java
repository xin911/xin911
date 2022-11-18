import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 输入一个数组返回金条分割的最小代价
 * 证明需要使用哈夫曼编码
 * 贪心使用结果验证，不要进行求证。
 * 使用小根堆
 * 例子：
 * [10, 30, 20]
 * 
 * 拆分时，10->消耗60，30->消耗50，总消耗110；
 * 拆分时，30->消耗60，10->消耗30，总消耗90.
 * PS：
 * 每次进行最高的数字进行拆分消耗，这种贪心算法是无效的。[97, 98, 99, 100]，拆分最多的100，明显不成立。切分97+98才对。
 * 使用小根堆解决。
 * 
 * 
 */
public class 贪心算法的应用分金问题 {
	public static void main(String[] args) {
		System.out.println(使用小根堆解决求所需最小金额(new int[] { 2, 1, 7, 3, 4, 2, 1 }));
		暴力求解的对数器(new int[] { 2, -1, 7, 1 });
		暴力求解的对数器(new int[] { 2, 1, 7, 3, 4, 2, 1 });
	}

	/**
	 * [2, 1, 7, 3, 4, 2, 1]
	 * 入堆->
	 * [1, 1, 2, 2, 3, 4, 7] 弹出前两个元素, 加和后入堆
	 * [2, 3, 4, 4, 7]
	 * [4, 4, 5, 7]
	 * [5, 8, 7]
	 * [7, 13]
	 * [20]
	 * 形成的一棵树，这就是最好的分割方案。源自哈夫曼编码
	 * 
	 * @param nums
	 */
	private static int 使用小根堆解决求所需最小金额(int[] nums) {
		PriorityQueue<Integer> pq = Arrays.stream(nums).boxed().collect(PriorityQueue::new, PriorityQueue::add,
				(o1, o2) -> System.out.println(o1 + " " + o2));
		int sum = 0;
		int cur = 0;
		while (pq.size() > 1) {
			cur = pq.poll() + pq.poll();
			sum += cur;
			pq.add(cur);
		}
		return sum;
	}

	private static int 暴力求解的对数器(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		List<Integer> sumList = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();
		int max = 暴力求解的对数器(sumList, results, new ArrayList<>(), 0, nums, 0);
		results.stream().forEach(System.out::println);
		System.out.println("===max==" + max);
		sumList.stream().forEach(System.out::println);
		System.out.println("=====" + 暴力求解的对数器(0, nums, 0));
		results.stream().map(e -> e.stream().collect(Collectors.summingLong(o -> o.intValue())))
				.forEach(System.out::println);
		return 0;
	}

	private static int 暴力求解的对数器(List<Integer> sumList, List<List<Integer>> results, List<Integer> result,
			int sum, int[] nums,
			int start) {
		results.add(new ArrayList<>(result));
		sumList.add(sum);
		int max = sum;
		for (int i = start; i < nums.length; i++) {
			result.add(nums[i]);
			max = Math.max(max, 暴力求解的对数器(sumList, results, result, sum + nums[i], nums, i + 1));
			result.remove(result.size() - 1);
		}
		return max;
	}

	private static int 暴力求解的对数器(int sum, int[] nums, int start) {
		int max = sum;
		for (int i = start; i < nums.length; i++) {
			max = Math.max(max, 暴力求解的对数器(sum + nums[i], nums, i + 1));
		}
		return max;
	}
}
