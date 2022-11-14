import java.util.Arrays;

/**
 * 1、会议室的时间安排[ [1,3][1,5][2,4][3,6] ]假设小时
 * 2、最多安排几场会议
 * 
 * 结论：
 * 使用贪心算法，会议的开始时间最早，时间间隔最短，无效。
 * 会议的结束时间最早，有效
 */
public class 贪心算法的应用安排会议室的问题 {
	public static void main(String[] args) {
		会议[] 会议时间占用 = new 会议[] { new 会议(1, 3), new 会议(1, 5), new 会议(2, 4), new 会议(3, 6) };
		int 最多安排的会议数 = 解决会议室占用问题会议(会议时间占用);
		System.out.println("最多安排的会议数:" + Integer.valueOf(最多安排的会议数));
		System.out.println("最多安排的会议数:" + Integer.valueOf(暴力递归的解法(0, 会议时间占用, 0, 0)));

		System.out.println("开始");
		for (int i = 0; i < 100; i++) {
			会议时间占用 = 随机数组(20);
			int result = 0;
			if ((result = 解决会议室占用问题会议(会议时间占用)) != 暴力递归的解法(0, 会议时间占用, 0, 0)) {
				System.err.println("有错误");
			} else {
				System.out.println("数组个数：" + 会议时间占用.length + " result: " + result);
			}
		}
		System.out.println("结束");
	}

	/**
	 * 结束时间贪心
	 * 
	 * 结束时间点，也约束了开始时间。
	 * 贪心策略，源于尝试。不要去证明，可以后期使用对数器进行尝试。
	 * 
	 * @param 会议时间占用
	 * @return
	 */
	private static int 解决会议室占用问题会议(会议[] 会议时间占用) {
		// 先根据会议结束时间排序
		Arrays.sort(会议时间占用, (o1, o2) -> o1.end - o2.end);
		// Arrays.stream(会议时间占用).forEach(System.out::println);
		int 空闲的时间点 = 0;
		int 安排的会议数 = 0;
		// 依次遍历会议 会议结束早的先遍历
		for (int i = 0; i < 会议时间占用.length; i++) {
			if (空闲的时间点 <= 会议时间占用[i].start) { // 当前的空闲时间点,比会议占用的开始时间早，可以安排
				// 安排的会议数增加
				安排的会议数++;
				空闲的时间点 = 会议时间占用[i].end;
			}
		}
		return 安排的会议数;
	}

	/**
	 * 逐个排查每个会议。
	 * 纯暴力但绝对对。
	 * 
	 * @param 安排的会议数
	 * @param 会议时间占用
	 * @param 空闲的时间点
	 * @return
	 */
	private static int 暴力递归的解法(int 安排的会议数, 会议[] 会议时间占用, int 空闲的时间点, int start) {
		if (会议时间占用 == null || 会议时间占用.length == 0) {
			return 安排的会议数;
		}

		int max = 安排的会议数;
		// 当前安排的是什么会，每一个都进行枚举
		for (int i = start; i < 会议时间占用.length; i++) {
			if (会议时间占用[i].start >= 空闲的时间点) {
				// 会议 当前占用的会议 = 会议时间占用[i];
				// 会议[] 剩下的会议 = Arrays.stream(会议时间占用).filter(e -> 当前占用的会议 !=
				// e).toArray(会议[]::new);
				max = Math.max(max, 暴力递归的解法(安排的会议数 + 1, 会议时间占用, 会议时间占用[i].end, i + 1));
			}
		}

		return max;
	}

	/**
	 * 会议时间占用的数组
	 */
	private static 会议[] 随机数组(int timemax) {
		会议[] 会议时间占用的数组 = new 会议[Double.class.cast(Math.random() * 15).intValue()];
		for (int i = 0; i < 会议时间占用的数组.length; i++) {
			int start = Double.class.cast(Math.random() * (timemax + 1)).intValue();
			int end = Double.class.cast(Math.random() * (timemax + 1)).intValue();
			if (start == end) {
				会议时间占用的数组[i] = new 会议(start, end + 1);
			} else {
				会议时间占用的数组[i] = new 会议(Math.min(start, end), Math.max(start, end));
			}
		}
		return 会议时间占用的数组;
	}

}

class 会议 {
	int start;
	int end;

	/**
	 * @param start
	 * @param end
	 */
	public 会议(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "会议 [start=" + start + ", end=" + end + "]";
	}

}