import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
	public int uniquePaths(int m, int n) {
		return secondPlus(m, n);
	}

	/**
	 * 组合数学
	 * 时间复杂度：O(m)O(m)。由于我们交换行列的值并不会对答案产生影响，因此我们总可以通过交换 mm 和 nn 使得 m \leq
	 * nm≤n，这样空间复杂度降低至 O(\min(m, n))O(min(m,n))。
	 * 
	 * 空间复杂度：O(1)O(1)。
	 * 
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode.cn/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * C
	 * m−1
	 * m+n−2
	 * 
	 * =​
	 * (m+n−2)(m+n−3)⋯n
	 * -----------------
	 * (m−1)!
	 * ​
	 * =
	 * (m+n−2)!
	 * -----------------
	 * (m−1)!(n−1)!
	 * ​
	 * 
	 * @return
	 */
	public int first(int m, int n) {
		long ans = 1;
		for (int x = n, y = 1; y < m; ++x, ++y) {
			ans = ans * x / y;
		}
		return (int) ans;

	}

	public int second(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				System.out.printf("dp[%s][%s]:%s = dp[%s][%s]:%s + dp[%s][%s]:%s;", i, j, dp[i][j], i - 1, j,
						dp[i - 1][j], i, j - 1, dp[i][j - 1]);
				System.out.println();
			}
		}
		return dp[m - 1][n - 1];
	}

	public int secondPlus(int m, int n) {
		int[] cur = new int[n]; // 相当于上一行的所有数据
		Arrays.fill(cur, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				cur[j] += cur[j - 1];
				System.out.printf("cur[%s]:%s += cur[%s]:%s", j, cur[j], j - 1, cur[j - 1]);
				System.out.println();
			}
		}
		return cur[n - 1];
	}

}
// @lc code=end
