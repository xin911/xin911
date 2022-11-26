
/**
 * 假设有排成一行的N个位置，记为1~N，N>=2
 * 开始时，机器人在M位置上，M属于1～N
 * 如果机器人来到1位置上，那么下一步只能向右来到2位置
 * 如果机器人来到N位置上，那么下一步只能向左来到N-1位置
 * 如果机器人来到中间位置上，那么下一步可以向左也可能向右走
 * 规定机器人必须走K步，最终能来到P位置的方法有多少种
 * 给定四个参数N、M、K、P，返回方法数
 * 
 */
public class 动态规划的应用范围尝试模型机器人走路NMKP问题 {

	public static void main(String[] args) {
		int n = 0;
		int m = 0;
		int k = 0;
		int p = 0;

		机器人走路NMKP问题(0, 0, 0, 0);
	}

	private static int 机器人走路NMKP问题(int n, int m, int k, int p) {
		if (n < 2 || k < 1 || m < 1 || m > n || p < 1 || p > n) {
			return 0;
		}

		return 解决机器人走路NMKP问题(n, m, k, p);
	}

	private static int 解决机器人走路NMKP问题(int n, int m, int k, int p) {
		if (k == 0) {
			return m == p ? 1 : 0;
		}

		if (m == 1) {
			return 解决机器人走路NMKP问题(n, m + 1, k - 1, p);
		}

		if (m == n) {
			return 解决机器人走路NMKP问题(n, m - 1, k - 1, p);
		}

		return 解决机器人走路NMKP问题(n, m - 1, k - 1, p) + 解决机器人走路NMKP问题(n, m + 1, k - 1, p);
	}
}
