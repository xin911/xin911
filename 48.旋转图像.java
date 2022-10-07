import java.util.Objects;

/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
	public void rotate(int[][] matrix) {
		if (Objects.isNull(matrix)) {
			return;
		}
		int tmp = 0;
		// 0,0->0,2
		// 0,1->1,2
		// 0,2->2,2
		// 1,0->0,1
		// 1,1->1,1
		// 1,2->2,1

		// temp =matrix[row][col]
		// matrix[row][col] =matrix[n-col-1][row]
		// matrix[n-col-1][row] =matrix[n-row-1][n-col-1]
		// matrix[n-row-1][n-col-1] =matrix[col][n-row-1]
		// matrix[col][n-row-1] =temp
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < (matrix.length + 1) / 2; j++) {
				tmp = matrix[i][j];// 先保存该区域的点

				matrix[i][j] = matrix[matrix.length - 1 - j][i];// 把该区域下面的点旋转到该区域
				System.out.printf("matrix[%s][%s]:[%s] <- matrix[%s][%s]:[%s]", i, j, matrix[i][j],
						matrix.length - 1 - j, i, matrix[matrix.length - 1 - j][i]);
				System.out.println();
				matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j
						- 1];// 把该区域右下角的点旋转到该区域下面
				System.out.printf("matrix[%s][%s]:[%s] <- matrix[%s][%s]:[%s]", matrix.length - j - 1, i,
						matrix[matrix.length - j - 1][i], matrix.length - i - 1, matrix.length - j
								- 1,
						matrix[matrix.length - i - 1][matrix.length - j
								- 1]);
				System.out.println();
				matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];// 把该区域右边的点旋转到该区域右下角
				System.out.printf(
						"matrix[%s][%s]:[%s] = matrix[%s][%s]:[%s]",
						matrix.length - i - 1, matrix.length - j - 1,
						matrix[matrix.length - i - 1][matrix.length - j - 1], j, matrix.length - i - 1,
						matrix[j][matrix.length - i - 1]);
				System.out.println();
				matrix[j][matrix.length - i - 1] = tmp;// 将该区域的点旋转到该区域右边
			}
		}
		System.out.println(matrix);
	}

	/**
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * 1、swap(matrix[i][j], matrix[j][i])
	 * 1 4 7
	 * 2 5 8
	 * 3 6 9
	 * 2、swap(matrix[i][j], matrix[i][matrix.length-1-j]
	 * 7 4 1
	 * 8 5 2
	 * 9 6 3
	 * 
	 * @param matrix
	 */
	public void 依靠两次旋转(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}
}

// @lc code=end
