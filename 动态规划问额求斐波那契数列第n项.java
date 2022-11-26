
public class 动态规划问额求斐波那契数列第n项 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		System.out.println(斐波那契数列第N项另一种解法(100));
	}

	private static int 斐波那契数列第N项(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return 斐波那契数列第N项(n - 1) + 斐波那契数列第N项(n - 2);
	}

	private static int 斐波那契数列第N项另一种解法(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		int[] nums = new int[n + 1];
		nums[0] = 0;
		nums[1] = 1;
		int i = 2;
		while (i <= n) {
			nums[i] = nums[i - 1] - (nums[i - 1] + nums[i - 2]);
			i++;
		}
		return nums[n];
	}
}
