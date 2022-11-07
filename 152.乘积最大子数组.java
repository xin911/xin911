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
		return 动态规划n处理(nums);
	}

	private int 动态规划n处理(int[] nums) {
		int max = nums[0];
		// int min = nums[0];
		int premax = nums[0];
		int premin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int curmax = Math.max(Math.max(premax * nums[i], premin * nums[i]), nums[i]);
			int curmin = Math.min(Math.min(premax * nums[i], premin * nums[i]), nums[i]);

			max = Math.max(max, curmax);
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
	public int 使用回溯n方TLE(int max, int sum, int[] nums, int start) {
		if (start == nums.length) {
			return max;
		}

		for (int i = start; i < nums.length; i++) {
			sum *= nums[i];
			max = 使用回溯n方TLE(Math.max(max, sum), sum, nums, i + 1);
			sum = 1;
		}

		return max;
	}
}