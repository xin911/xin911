import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 经典回溯算法模版 {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 3 };

		// System.out.println("===subsets==");
		// 子数组排列(nums).forEach(System.out::println);
		// System.out.println("===subsetsWithDup==");
		// 子数组排列去重(nums).forEach(System.out::println);
		// System.out.println("====permute=");
		// 等长子数组全排列(new int[] { 1, 2, 3 }).forEach(System.out::println);
		// System.out.println("====permuteUnique=");
		// 等长排序子数组全排列去重(nums).forEach(System.out::println);
	}

	/**
	 * subsets 子数组全排列
	 * [1,2,3,3]
	 * 结果：
	 * []
	 * [1]
	 * [1, 2]
	 * [1, 2, 3]
	 * [1, 2, 3, 3]
	 * [1, 2, 3]
	 * [1, 3]
	 * [1, 3, 3]
	 * [1, 3]
	 * [2]
	 * [2, 3]
	 * [2, 3, 3]
	 * [2, 3]
	 * [3]
	 * [3, 3]
	 * [3]
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> 子数组排列(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		子数组排列(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void 子数组排列(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			子数组排列(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/**
	 * subsetsWithDup 子数组全排列去重
	 * [1,2,3,3]
	 * 结果：
	 * []
	 * [1]
	 * [1, 2]
	 * [1, 2, 3]
	 * [1, 2, 3, 3]
	 * [1, 3]
	 * [1, 3, 3]
	 * [2]
	 * [2, 3]
	 * [2, 3, 3]
	 * [3]
	 * [3, 3]
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> 子数组排列去重(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		子数组排列去重(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void 子数组排列去重(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue; // skip duplicates
			tempList.add(nums[i]);
			子数组排列去重(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/**
	 * 
	 * [1, 2, 3]
	 * 结果:
	 * [1, 2, 3]
	 * [1, 3, 2]
	 * [2, 1, 3]
	 * [2, 3, 1]
	 * [3, 1, 2]
	 * [3, 2, 1]
	 * 
	 * 时间复杂度：O(n \times n!)O(n×n!)，其中 nn 为序列的长度。
	 * 
	 * =n(n−1)…(n−k+1)，该式被称作 n 的 k - 排列，或者部分排列。
	 * 
	 * 而 \sum_{k = 1}^{n}{P(n, k)} = n! + \frac{n!}{1!} + \frac{n!}{2!} +
	 * \frac{n!}{3!} + \ldots + \frac{n!}{(n-1)!} < 2n! + \frac{n!}{2} +
	 * \frac{n!}{2^2} + \frac{n!}{2^{n-2}} < 3n!∑
	 * k=1
	 * n
	 * ​
	 * P(n,k)=n!+
	 * 1!
	 * n!
	 * ​
	 * +
	 * 2!
	 * n!
	 * ​
	 * +
	 * 3!
	 * n!
	 * ​
	 * +…+
	 * (n−1)!
	 * n!
	 * ​
	 * <2n!+
	 * 2
	 * n!
	 * ​
	 * +
	 * 2
	 * 2
	 * 
	 * n!
	 * ​
	 * +
	 * 2
	 * n−2
	 * 
	 * n!
	 * ​
	 * <3n!
	 * 
	 * 这说明 \textit{backtrack}backtrack 的调用次数是 O(n!)O(n!) 的。
	 * 
	 * 而对于 \textit{backtrack}backtrack 调用的每个叶结点（共 n!n! 个），我们需要将当前答案使用 O(n)O(n)
	 * 的时间复制到答案数组中，相乘得时间复杂度为 O(n \times n!)O(n×n!)。
	 * 
	 * 因此时间复杂度为 O(n \times n!)O(n×n!)。
	 * 
	 * 空间复杂度：O(n)O(n)，其中 nn
	 * 为序列的长度。除答案数组以外，递归函数在递归过程中需要为每一层递归函数分配栈空间，所以这里需要额外的空间且该空间取决于递归的深度，这里可知递归调用深度为
	 * O(n)O(n)。
	 * 
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode.cn/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> 等长子数组全排列(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		等长子数组全排列(list, new ArrayList<>(), nums);
		return list;
	}

	private static void 等长子数组全排列(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				等长子数组全排列(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	/**
	 * [1, 2, 3, 3]
	 * 结果：
	 * [1, 2, 3, 3]
	 * [1, 3, 2, 3]
	 * [1, 3, 3, 2]
	 * [2, 1, 3, 3]
	 * [2, 3, 1, 3]
	 * [2, 3, 3, 1]
	 * [3, 1, 2, 3]
	 * [3, 1, 3, 2]
	 * [3, 2, 1, 3]
	 * [3, 2, 3, 1]
	 * [3, 3, 1, 2]
	 * [3, 3, 2, 1]
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> 等长排序子数组全排列去重(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		等长排序子数组全排列去重(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private static void 等长排序子数组全排列去重(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				等长排序子数组全排列去重(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		combinationSum(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private static void combinationSum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,
			int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				combinationSum(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same
																			// elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		combinationSum2(list, new ArrayList<>(), nums, target, 0);
		return list;

	}

	private static void combinationSum2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,
			int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue; // skip duplicates
				tempList.add(nums[i]);
				combinationSum2(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
