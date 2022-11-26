/**
 * 从左向右尝试模型
 * 
 * 背包问题:
 * 给定两个长度都为N的数组weights和values
 * weight[i]和values[i]代表i号物品的重量和价值
 * 给定一个正数bag，表示一个载重的袋子
 * 你装的物品不能超过这个重量
 * 返回你能装下的最多的价值是多少
 * 
 */
public class 动态规划的应用从左向右尝试模型背包问题 {
	public static void main(String[] args) {
		int[] weights = new int[] { 1, 3, 5, 7, 9 };
		int[] values = new int[] { 2, 4, 6, 8, 11 };
		int 载重 = 10;
		int result = 第一种暴力破解能装下最大的价值是多少(0, 0, weights, values, 载重, 0);
		System.out.println("result: " + result);
		System.out.println(第一种暴力破解能装下最大的价值是多少(0, 0, new int[] { 3, 2, 4, 7 }, new int[] { 5, 6, 3, 19 }, 11, 0));
	}

	private static int 第一种暴力破解能装下最大的价值是多少(int max, int sum, int[] weights, int[] values, int 载重, int start) {
		if (weights == null || weights.length == 0 || values == null || values.length == 0) {
			return max;
		}
		if (载重 < 0) {
			return max;
		}
		max = sum;
		for (int i = start; i < weights.length; i++) {
			max = Math.max(max, 第一种暴力破解能装下最大的价值是多少(max, sum + values[i], weights, values, 载重 - weights[i], i + 1));
		}

		return max;
	}

	/**
	 * 第二种暴力破解能装下最大的价值是多少
	 * 
	 * @param weights
	 * @param values
	 * @param 载重
	 * @param start
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int 第二种暴力破解能装下最大的价值是多少(int[] weights, int[] values, int 载重, int start) {
		if (载重 < 0) { // base case 1
			return -1;
		}

		// 载重 >= 0
		if (start == weights.length) { // base case 2
			return 0;
		}

		// 有货也有空间
		int p1 = 第二种暴力破解能装下最大的价值是多少(weights, values, 载重, start + 1);
		int p2 = -1;
		int p2next = 第二种暴力破解能装下最大的价值是多少(weights, values, 载重 - weights[start], start + 1);
		if (p2 != -1) {
			p2 = values[start] + p2next;
		}

		return Math.max(p1, p2);
	}

	/**
	 * 整体思路，是建立一个二维数组，设计变量的。分别是「载重」和「start」
	 * 使用数组，将变量进行缓存。
	 * 
	 * 
	 * 
	 * @param weights
	 * @param values
	 * @param 载重
	 * @param start
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int 第二种使用动态规划的方式能装下最大的价值是多少(int[] weights, int[] values, int 载重, int start) {
		int n = weights.length;
		// 剩余重量如果很大100000，那么就会建立一个特别大的数组。。？这么做对于空间没有必要吧。。。？
		int[][] dp = new int[n + 1][载重 + 1];
		for (int index = n - 1; index >= 0; index--) {
			for (int rest = 1; rest <= 载重; rest++) {
				// 有货也有空间
				int p1 = dp[index + 1][rest];
				int p2 = -1;
				if (rest >= weights[index]) {
					p2 = values[index] + dp[index + 1][rest - weights[index]];
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}

		return dp[0][载重];
	}

}