import java.util.Objects;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
	public int[] searchRange(int[] nums, int target) {

		if (Objects.isNull(nums)) {
			return new int[] { -1, -1 };
		}
		return new int[] { findFirst(nums, target), findLast(nums, target) };
	}

	public int findFirst(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;
		while (start <= end) {
			System.out.println("1start:" + start + ", end:" + end + ",result:" + result);
			int middle = (start + end) >>> 1;
			if (target <= nums[middle]) {
				end = middle - 1;
			} else if (target > nums[middle]) {
				start = middle + 1;
			}
			if (nums[middle] == target) {
				if (result != -1) {
					result = Math.min(result, middle);
				} else {
					result = middle;
				}
			}
		}
		return result;

	}

	public int findLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;
		while (start <= end) {
			System.out.println("2start:" + start + ", end:" + end + ",result:" + result);
			int middle = (start + end) >>> 1;
			if (nums[middle] <= target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
			if (nums[middle] == target) {
				result = Math.max(result, middle);

			}
		}
		return result;
	}
}
// @lc code=end
