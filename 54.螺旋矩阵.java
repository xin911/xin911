import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		// 00 01 02 12 22 21 20 10 11
		if (Objects.isNull(matrix)) {
			return new ArrayList<>();
		}

		if (matrix.length == 0) {
			return new ArrayList<>();
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		List<Integer> result = new ArrayList<>();
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// 向右
			for (int j = colBegin; j <= colEnd; j++) {
				// 左上-右上
				result.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// 向下
			for (int j = rowBegin; j <= rowEnd; j++) {
				// 右上-右下
				result.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					// 右下-左下
					result.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				for (int j = rowEnd; j >= rowBegin; j--) {
					// 左下-左上
					result.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return result;
	}
}
// @lc code=end
