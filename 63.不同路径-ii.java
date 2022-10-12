import java.util.Arrays;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (Objects.isNull(obstacleGrid)) {
			return 0;
		}
		if (obstacleGrid.length == 0) {
			return 0;
		}
		if (obstacleGrid[0].length == 0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[] cur = new int[obstacleGrid[0].length];
		cur[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				// String logComment = String.format("i:%s, j:%s", i, j);
				// System.out.println(logComment);
				if (obstacleGrid[i][j] >= 1) {
					cur[j] = 0;
					continue;
				}
				if (j >= 1) {
					cur[j] += cur[j - 1];
				}
				// System.out.println("===>" + logComment);
			}
			Arrays.stream(cur).forEach(System.out::print);
			System.out.println();
		}
		return cur[obstacleGrid[0].length - 1];
	}
}
// @lc code=end
