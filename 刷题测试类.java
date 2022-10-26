import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class 刷题测试类 {
	public static void main(String[] args) {
		System.out.println("开始");
		// subsets(new int[] { 2, 3 });
		// 去重(new int[] { 10, 1, 2, 7, 6, 1, 5 });
		// removeDuplicates(new int[] { 1, 1, 2, 5, 6, 7, 10 });
		// 测试mathrandom的均衡性();
		// 测试双重for循环的break(); // break只跳出单循环。
		
	}

	private static void 测试双重for循环的break() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 200; j++) {
				if (j % 10 == 0) {
					System.out.println("测试j:" + j);
					break;
				}
			}
			System.out.println("测试i:" + i);
		}
	}

	/**
	 * 计算机中小数不是无穷的，是有限的
	 */
	private static void 测试mathrandom的均衡性() {
		int count = 0;
		for (int i = 0; i < 100000; i++) {
			if (Math.random() < 0.8) {
				count++;
			}
		}
		System.out.println((double) count / (double) 100000);
		count = 0;
		for (int i = 0; i < 100000; i++) {
			if (Math.max(Math.random(), Math.random()) < 0.8) {
				count++;
			}
		}
		System.out.println((double) count / (double) 100000);

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		System.out.println(list.toString());
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			System.out.println("i: " + i + ", tempList: " + tempList);
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1); // [[], [2], [2, 3], [3]]
			tempList.remove(tempList.size() - 1);
			System.out.println("i: " + i + ", tempList: " + tempList);
			System.out.println("============");
		}
	}

	public static int 去重(int[] candidates) {
		Arrays.sort(candidates);
		Arrays.stream(candidates).forEach(System.out::print);
		System.out.println();
		if (candidates.length == 1) {
			return 0;
		}
		// 1,1,2,5,6,7,10
		int left = 0;
		int right = 0;
		while (right < candidates.length) {
			if (right >= candidates.length) {
				return left;
			}
			if (candidates[left] == candidates[right]) {
				right++;
				continue;
			}
			candidates[++left] = candidates[right];
		}
		Arrays.stream(candidates).forEach(System.out::print);
		return left;
	}

	public static int removeDuplicates(int[] nums) {
		if (Objects.isNull(nums)) {
			return 0;
		}
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int x = 0;
		int y = 0;
		while (y < nums.length) {
			if (nums[x] == nums[y]) {
				y++;
				continue;
			}
			nums[++x] = nums[y];
		}
		System.out.println(nums);
		Arrays.stream(nums).forEach(System.out::print);
		return x + 1;
	}
}
