import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
class Solution {
	public int shortestSubarray(int[] nums, int k) {
		if (Objects.isNull(nums) || nums.length < 1) {
			return -1;
		}
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		shortestSubarray(list, nums, k, 0);
		if (list.size() <1){
			return -1;
		}
		return 0;
	}

	private void shortestSubarray(List<Integer> list, int[] nums, int k, int index) {
		for (int i = index; i < nums.length; i++) {
			list.add(Integer.valueOf(i));
			if (nums[i] < k) {
				shortestSubarray(list, nums, k, i);
			}
			if (nums[i] >= k){
				return;
			}
			list.remove(list.size());
		}
	}
}
// @lc code=end
