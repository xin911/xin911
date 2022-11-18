import java.util.PriorityQueue;

/**
 * 输入正整数数组，输出你最后获得的最大钱数
 * 最多K个项目
 * W是初始资金
 * profit[] 和 Capital[] 是等长
 * 返回最终最大的资金
 * 
 * 重点: 使用大根堆和小根堆
 */
public class 贪心算法的应用计算纯利润 {
	public static void main(String[] args) {

		返回K个项目中能得到的最大利润(0, 0, null, null);
	}

	private static int 返回K个项目中能得到的最大利润(int 最大项目数, int 当前资金, int[] 利益, int[] 损耗) {
		PriorityQueue<项目> 最小成本堆 = new PriorityQueue<>((o1, o2) -> o1.成本 - o2.成本);
		PriorityQueue<项目> 最大收益堆 = new PriorityQueue<>((o1, o2) -> o2.利润 - o1.利润);
		for (int i = 0; i < 利益.length; i++) {
			最小成本堆.add(new 项目(利益[i], 损耗[i]));

		}

		for (int i = 0; i < 最大项目数; i++) { // 不可以忽略，K轮拿K个项目
			while (!最小成本堆.isEmpty() && 最小成本堆.peek().成本 <= 当前资金) {
				最大收益堆.add(最小成本堆.poll());
			}

			if (最大收益堆.isEmpty()) {
				return 当前资金;
			}

			当前资金 += 最大收益堆.poll().利润;
		}
		return 当前资金;
	}
}

class 项目 {
	int 利润;
	int 成本;

	/**
	 * @param 利润
	 * @param 成本
	 */
	public 项目(int 利润, int 成本) {
		this.利润 = 利润;
		this.成本 = 成本;
	}
}
