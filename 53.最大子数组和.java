import java.util.Objects;

/*
 * @lc app=leetcode.cn id=53 lang=java
 * dp[i]=max{nums[i],dp[i−1]+nums[i]}


 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
	public int maxSubArray(int[] nums) {
		if (Objects.isNull(nums)) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int sum = 0;
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			// 状态转移方程 dp[i]=max{nums[i],dp[i−1]+nums[i]}
			max = Math.max(sum = sum + nums[i], max);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}
}
// @lc code=end
