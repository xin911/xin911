import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 * 任何一个动态规划，源于暴力递归的优化。
 * 如何将暴力递归转化为动态规划？
 */
public class 动态规划问题 {
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();

		backtrack(result, "", "123".toCharArray(), 0);
		System.out.println(result);
	}

	/**
	 * [1,2,3]
	 * [, 3, 2, 23, 1, 13, 12, 123]
	 * 
	 * @param result
	 * @param path
	 * @param chars
	 * @param start
	 */
	private static void backtrack(List<String> result, String path, char[] chars, int start) {
		if (start == chars.length) {
			result.add(path);
			return;
		}

		String no = path;
		backtrack(result, no, chars, start + 1);
		String yes = path + chars[start];
		backtrack(result, yes, chars, start + 1);
	}

}