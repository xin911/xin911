import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */

// @lc code=start
class Solution {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int cnt = 0;
		if (nums == null || nums.length == 0) {
			return cnt;
		}

		return n平方求和计算(nums, lower, upper, cnt);
		// return 使用前数组和n平方计算(nums, lower, upper);
	}

	public static long 二分法求和(long sum, int[] nums, int start, int end) {
		if (start > end) {
			return sum;
		}
		if (start == end) {
			return sum + nums[start];
		}

		return 二分法求和(sum + nums[start] + nums[end], nums, start + 1, end - 1);
	}

	/**
	 * Time Limit Exceeded
	 * 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @param cnt
	 * @return
	 */
	private int countRangeSum(int[] nums, int lower, int upper, int cnt) {
		for (int i = 1; i <= nums.length; i++) {
			long sum = nums[i - 1];
			System.out.println(sum);
			if (lower <= sum && sum <= upper) {
				cnt++;
			}
			for (int j = i; j < nums.length; j++) {
				// sum += nums[j];
				sum = 二分法求和(sum, nums, i, j);
				System.out.println(sum);
				if (lower <= sum && sum <= upper) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	/**
	 * Time Limit Exceeded
	 * 
	 * @param num
	 * @param lower
	 * @param upper
	 * @param cnt
	 * @return
	 */
	private int n平方求和计算(int[] num, long lower, long upper, int cnt) {
		for (int i = 1; i < num.length + 1; i++) {
			long sum = num[i - 1];
			// System.out.println(sum);
			if (lower <= sum && sum <= upper) {
				cnt++;
			}
			for (int j = i; j < num.length; j++) {
				if (sum <= upper) {
					break;
				}
				sum += num[j];
				// System.out.println(sum);
				if (lower <= sum && sum <= upper) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int 使用前数组和n平方计算(int[] nums, int lower, int upper) {
		// 求前数组和
		long[] sums = new long[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
		// System.out.println(Arrays.stream(sums).boxed().map(String::valueOf).collect(Collectors.joining(",")));
		int cnt = 0;
		for (int i = 0; i < sums.length; i++) {
			long sum = sums[i];
			if (lower <= sum && sum <= upper) {
				cnt++;
			}
			for (int j = i + 1; j < sums.length; j++) {
				sum = sums[j] - sums[i];
				// System.out.println(sum);
				if (lower <= sum && sum <= upper) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
// @lc code=end

class countRangeSumTest {
	/**
	 * Integer[]数组直接打印数值出来
	 * int[]被认为是一个基础Object的变量，只能打印地址
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[] { -2147483647, 0, -2147483647, 2147483647 };
		long size = Integer.MAX_VALUE + 1L;
		for (int m = 0; m < size; m++) {
			System.out.println("test");
			if (m == 100) {
				break;
			}
		}
		// int[] sum = new int[num.length + 1];
		System.out.println(num.toString()); // 地址 [I@7344699f
		System.out.println(Arrays.asList(num)); // [I@7344699f
		System.out.println(Arrays.asList(num).toString()); // [I@7344699f
		System.out.println(new ArrayList<>(Arrays.asList(num)).toString()); // 地址[I@7344699f
		System.out.println(new ArrayList<>(Arrays.asList(new int[] { 1, 2 })).toString()); // [I@7344699f
		System.out.println(new ArrayList<>(Arrays.asList(new Integer[] { 1, 2 })).toString()); // [1, 2]
		new ArrayList<>(Arrays.asList(new int[] { 1, 2 })).forEach(System.out::println); // [I@7344699f
		new ArrayList<>(Arrays.asList(new Integer[] { 1, 2 })).forEach(System.out::print); // 12
		System.out.println();
		// for (int i = 0; i < num.length; i++) {
		// if (i == 0) {
		// sum[0] = num[0];
		// continue;
		// }
		// sum[i] = sum[i - 1] + num[i];
		// }
		// for (int i = 0; i < num.length; ++i)
		// sum[i + 1] = sum[i] + num[i];
		// System.out.println(Arrays.stream(sum).boxed().map(String::valueOf).collect(Collectors.joining(",")));
		num = new int[] { -2, 5, -1 };
		int lower = -2, upper = 2, cnt = 0;
		cnt = 使用前数组和n平方计算(num, lower, upper);
		System.out.println("cnt: " + cnt);
	}

	private static long n平方求和(int[] num, long lower, long upper, long cnt) {
		for (int i = 1; i < num.length + 1; i++) {
			long sum = num[i - 1];
			System.out.println(sum);
			if (lower <= sum && sum <= upper) {
				cnt++;
			}
			for (int j = i; j < num.length; j++) {
				sum += num[j];
				System.out.println(sum);
				if (lower <= sum && sum <= upper) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static long 二分法求和(long sum, int[] nums, int start, int end) {
		if (start > end) {
			return sum;
		}
		if (start == end) {
			return sum + nums[start];
		}

		return 二分法求和(sum + nums[start] + nums[end], nums, start + 1, end - 1);
	}

	public static int 使用前数组和n平方计算(int[] nums, int lower, int upper) {
		// 求前数组和
		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
		System.out.println(Arrays.stream(sums).boxed().map(String::valueOf).collect(Collectors.joining(",")));
		int cnt = 0;
		for (int i = 0; i < sums.length; i++) {
			int sum = sums[i];
			if (lower <= sum && sum <= upper) {
				cnt++;
			}
			for (int j = i + 1; j < sums.length; j++) {
				sum = sums[j] - sums[i];
				System.out.println(sum);
				if (lower <= sum && sum <= upper) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}