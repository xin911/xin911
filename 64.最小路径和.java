import java.util.Arrays;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
	public int minPathSum(int[][] grid) {
		if (Objects.isNull(grid)) {
			return 0;
		}

		if (grid.length == 0) {
			return 0;
		}

		if (grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		if (m == 1 && n == 1) {
			return grid[0][0];
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					grid[i][j] += grid[i][j - 1];
				} else if (j == 0) {
					grid[i][j] += grid[i - 1][j];
				} else {
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
			Arrays.stream(grid).forEach(System.out::print);
			System.out.println();
		}

		return grid[m - 1][n - 1];
	}
}
// @lc code=end
