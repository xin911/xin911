import java.util.Objects;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
	public int searchInsert(int[] nums, int target) {
		int fromIndex = 0;
		int toIndex = nums.length - 1;
		int result = 0;
		if (Objects.isNull(nums)) {
			return 0;
		}
		if (target < nums[0]) {
			return 0;
		}
		if (nums[nums.length - 1] < target) {
			return nums.length;
		}
		while (fromIndex <= toIndex) {
			int middle = (fromIndex + toIndex) >>> 1;
			System.out.println("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", middle: " + middle
					+ ", reuslt: " + result + "");
			if (target < nums[middle]) {
				toIndex = middle - 1;
			} else if (nums[middle] < target) {
				fromIndex = middle + 1;
			} else {
				return middle;
			}
		}
		return fromIndex;
	}
}
// @lc code=end
