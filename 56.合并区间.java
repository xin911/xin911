import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
	public int[][] merge(int[][] intervals) {
		if (Objects.isNull(intervals)) {
			return new int[][] {};
		}

		if (intervals.length <= 1) {
			return intervals;
		}

		// 排序
		Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

		List<int[]> merged = new ArrayList<>();
		merged.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];

			if (merged.get(merged.size() - 1)[1] < left) {
				merged.add(intervals[i]);
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}
}
// @lc code=end
