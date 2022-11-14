import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1、最自然智慧的算法.
 * 2、用一种局部最功利的标准，总是做出在当前看来是最好的选择
 * 3、难点在于证明局部最功利的标准可以得到全局最优解
 * 4、对于贪心算法的学习，主要以增加阅历、经验为主
 * 
 * 例子:
 * 开会的时候，选出最有价值客户
 * 观点1、购买最多
 * 观点2、登陆最多的用户，浏览最多的用户，转发最多的用户
 * 观点3、不退款的用户
 * 
 * 每个人的说法，对于自己都是贪心算法。
 * 局部贪心，贪出全局最优解，贪心有效
 * 否则贪心无效。
 */
public class 贪心算法的应用拼接最小字符串 {

	public static void main(String[] args) {
		String[] strs = new String[] { "3", "2" };
		String a = "b";
		String b = "ba";
		// System.out.println((a + b).compareTo(b + a));
		System.out.println(拼接最小字符串(strs));
	}

	private static String 拼接最小字符串(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// return Arrays.stream(strs).sorted((o1, o2) -> (o1 + o2).compareTo(o2 +
		// o1)).collect(Collectors.joining(","));

		return Arrays.stream(strs).sorted((o1, o2) -> {
			System.out.println(o1.compareTo(o2));
			System.out.println(o2.compareTo(o1));
			return (o1 + o2).compareTo(o2 + o1); // 值<0 取o1再取o2， 值>=0的话， 先取o2再取o1
		}).collect(Collectors.joining(","));
	}

}
