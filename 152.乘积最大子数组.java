/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
	public int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		// return 使用回溯n方TLE(Integer.MIN_VALUE, 1, nums, 0);
		return 动态规划N处理(nums);
	}

	/**
	 * 只能使用动态规划，O(N)的时空复杂度
	 * 三种情况：
	 * 1、nums[i]数字最大
	 * 2、sum[i-1]最大值 * nums[i]最大
	 * 3、sum[i-1]最小值 * nums[i]最大
	 * 
	 * @param nums
	 * @return
	 */
	private int 动态规划N处理(int[] nums) {
		int max = nums[0];
		// int min = nums[0];
		int premax = nums[0];// 上一局部最大值
		int premin = nums[0];// 上一局部最小值
		for (int i = 1; i < nums.length; i++) {
			// 上一局部最大值，与当前数字相乘， 可能变为局部最小值
			// 上一局部最小值，与当前数字相乘， 可能变为局部最大值
			int curmax = Math.max(Math.max(premax * nums[i], premin * nums[i]), nums[i]);
			int curmin = Math.min(Math.min(premax * nums[i], premin * nums[i]), nums[i]);

			max = Math.max(max, curmax); // 推高最大值，能推高最大值就推高
			// min = Math.min(min, curmin);
			premax = curmax;
			premin = curmin;
		}
		return max;
	}

}

// @lc code=end
class 其他的解决方案 {
	/**
	 * 暴力破解
	 * 
	 * @param max
	 * @param sum
	 * @param nums
	 * @param start
	 * @return
	 */
	@SuppressWarnings("unuserd")
	public int 使用回溯N方TLE(int max, int sum, int[] nums, int start) {
		if (start == nums.length) {
			return max;
		}

		for (int i = start; i < nums.length; i++) {
			sum *= nums[i];
			max = 使用回溯N方TLE(Math.max(max, sum), sum, nums, i + 1);
			sum = 1;
		}

		return max;
	}

	public static void main(String[] args) {
		int result = 使用递归的方式N处理(0, 1, 1, new int[] { 2, 3, -4, 3, 4 }, 0);
		System.out.println("result: " + result);
	}

	public static int 使用递归的方式N处理(int max, int premax, int premin, int[] nums, int start) {
		if (start == nums.length) {
			return max;
		}

		// 局部最大很有可能转化为局部最小值。
		int curmax = Math.max(Math.max(premax * nums[start], premin * nums[start]), nums[start]);
		// 局部最小很有可能转化为局部最大值。需要保存着
		int curmin = Math.min(Math.min(premax * nums[start], premin * nums[start]), nums[start]);
		return 使用递归的方式N处理(Math.max(max, Math.max(
				curmax, curmin)),
				Math.max(curmax, curmin),
				Math.min(curmax, curmin), nums, start + 1);
	}

}