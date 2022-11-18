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
		int result = 能装下最大的价值是多少(0, 0, weights, values, 载重, 0);
		System.out.println("result: " + result);
	}

	private static int 能装下最大的价值是多少(int max, int sum, int[] weights, int[] values, int 载重, int start) {
		if (weights == null || weights.length == 0 || values == null || values.length == 0) {
			return max;
		}
		if (载重 < 0) {
			return max;
		}
		max = sum;
		for (int i = start; i < weights.length; i++) {
			max = Math.max(max, 能装下最大的价值是多少(max, sum + values[i], weights, values, 载重 - weights[i], i + 1));
		}

		return max;
	}

}