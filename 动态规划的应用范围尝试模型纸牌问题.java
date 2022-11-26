import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定一个整形数组,代表数值不同的纸牌排成一条线
 * 玩家A玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或者最右的纸牌
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 */
public class 动态规划的应用范围尝试模型纸牌问题 {
	public static void main(String[] args) {
		int[] 随机生成数组 = 随机生成数组(52, 13);
		int[] nums = new int[] { 7, 1, 6, 10, 10, 2, 9 };
		int result = 范围模型纸牌问题的错误解答(nums);
		System.out.println("result错误解:" + result);
		result = 范围模型纸牌问题(new int[] { 7, 10, 1, 2 });
		System.out.println("result正解:" + result);

	}

	private static int[] 随机生成数组(int cardsize, int maxsize) {
		int[] result = new int[cardsize];
		for (int i = 0; i < cardsize; i++) {
			result[i] = Double.class.cast(Math.random() * maxsize).intValue();
		}
		System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(",")));
		return result;
	}

	/**
	 * 这么做是不对的。
	 * [70,100,1,4]
	 * 
	 * A不会选择70，因为会把100暴露出来。所以会选择4
	 * [70, 100, 1]
	 * B无论怎么选，都会暴露100，所以会选择70.
	 * [100, 1]
	 * A选择100，B选择1
	 * 
	 * A 104
	 * B 71
	 * 
	 * 下面的是A聪明，B傻子的问题
	 * 
	 * @param nums
	 * @return
	 */
	private static int 范围模型纸牌问题的错误解答(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int max = 0;
		while (left <= right) {
			max += Math.max(nums[left], nums[right]);
			if (nums[left] < nums[right]) {
				right--;
			} else {
				left++;
			}
			if (nums[left] < nums[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	/**
	 * [ 7, 10,1, 2 ]
	 * 不能通过遍历，因为遍历结果一定是最大的那个（A聪明 B傻）结果。ß
	 * @param nums
	 * @return
	 */
	private static int 范围模型纸牌问题(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// 比较先手摸牌第一张或者最后一张谁的分高
		return Math.max(先手摸牌(nums, 0, nums.length - 1), 后手摸牌(nums, 0, nums.length - 1));
	}

	/**
	 * 终止条件：只剩下一张纸牌时，返回这张纸牌的数值大小
	 * 
	 * 当剩下的不止一张纸牌的情况时：
	 * 因为作为先手，既可以摸走最左侧的牌，也可以摸走最右侧的牌，
	 * 如果先以先手摸走左侧的牌，得到的最终数值，就是最左侧的牌值+以后手摸剩下的牌所获得的值
	 * 如果先以先手摸走右侧的牌，得到的最终数值，就是最右侧的牌值+以后手摸剩下的牌所获得的值，
	 * 题目有说摸牌的人都很聪明，所以他一定可以计算出这两种情况的较大值
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private static int 先手摸牌(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}

		int 摸左面的牌 = nums[left] + 后手摸牌(nums, left + 1, right);
		int 摸右面的牌 = nums[right] + 后手摸牌(nums, left, right - 1);
		return Math.max(摸左面的牌, 摸右面的牌);
	}

	/**
	 * 终止条件：只剩一张牌时，此时作为后手是摸不到牌的，返回0
	 * 当剩下的不止一张纸牌的情况时：作为后手，摸牌是受先手影响的，
	 * 如果先手摸走了左侧的牌，后手只能从剩下的牌中以先手的形式做选择，
	 * 如果先手摸走了右侧的牌，后手只能从剩下的牌中以先手的形式做选择。
	 * 但是先手一定会计算好，让后手得到的牌值，一定是这两种情况中较小的那种。
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private static int 后手摸牌(int[] nums, int left, int right) {
		if (left == right) {
			return 0;
		}
		int 摸左面的牌 = 先手摸牌(nums, left + 1, right);
		int 摸右面的牌 = 先手摸牌(nums, left, right - 1);
		// 体现两位牌手都非常聪明。虽然B牌手尽力获取最大值的牌，但是A牌手会给B尽量小的“选择权”
		return Math.min(摸左面的牌, 摸右面的牌);
	}
}
