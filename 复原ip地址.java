import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class 复原ip地址 {

	public static void main(String[] args) {
		/**
		 * abc
		 * [, a, a.b, a.b.c, a.c, b, b.c, c]
		 */
		// System.out.println(restoreIpAddresses("1234"));

		int[] nums = new int[] { 1, 2, 3};
		List<List<Integer>> results = new ArrayList<>();
		backtrack(results, new ArrayList<>(), nums, 0);
		results.stream().forEach(System.out::println);
	}

	public static void backtrack(List<List<Integer>> results, List<Integer> result, int[] nums, int start) {
		if (nums == null || nums.length == 0) {
			return;
		}

		results.add(new ArrayList<>(result));
		for (int i = start; i < nums.length; i++) {
			
		}

	}

	// public static List<String> restoreIpAddresses(String s) {
	// if (Objects.isNull(s)) {
	// return new ArrayList<>();
	// }

	// List<String> result = new ArrayList<>();
	// // result = backtrackTemplate(s);

	// List<String> results = new ArrayList<>();
	// 回溯(results, new ArrayList<>(), s.toCharArray(), 0);
	// System.out.println(results.toString());
	// return results;
	// }

	// private static List<String> backtrackTemplate(String s) {
	// List<List<String>> results = new ArrayList<>();
	// List<String> result = new ArrayList<>();
	// backtrack(results, result, s.toCharArray(), 0);
	// List<String> ips = results.stream().map(e ->
	// e.stream().collect(Collectors.joining(".")))
	// .collect(Collectors.toList());
	// System.out.println(ips.toString());
	// return ips;
	// }

	// public static void backtrack(List<List<String>> results, List<String> result,
	// char[] digit, int start) {

	// // digit[start] + digit[start + 1] + digit[start + 2]

	// // 剩下的条件
	// // 1、result的size只能是4，超过4的返回
	// // 2、单个字符串必须是数字， 且数字必须小于256
	// results.add(new ArrayList<>(result));
	// for (int i = start; i < digit.length; i++) {

	// result.add(String.valueOf(digit[i]));
	// backtrack(results, result, digit, i + 1);
	// result.remove(result.size() - 1);
	// }
	// }

	// /**
	// * 123
	// * [1, 12, 123, 13, 2, 23, 3]
	// *
	// * @param results
	// * @param result
	// * @param digit
	// * @param start
	// */
	// public static void backtrackTemplate(List<StringBuilder> results,
	// StringBuilder result, char[] digit,
	// int start) {
	// if (result.length() != 0) {
	// results.add(new StringBuilder(result));
	// }
	// for (int i = start; i < digit.length; i++) {
	// result.append(digit[i]);
	// backtrackTemplate(results, result, digit, i + 1);
	// result.deleteCharAt(result.length() - 1);
	// }
	// }

	// /**
	// * 123
	// * [1, 12, 123, 13, 2, 23, 3]
	// *
	// * @param results
	// * @param result
	// * @param digit
	// * @param start
	// */
	// public static void 回溯(List<String> results, List<Integer> path, char[] digit,
	// int start) {

	// if (path.size() == 4 && start == digit.length) {
	// results.add(path.stream().map(String::valueOf).collect(Collectors.joining(".")));
	// return;
	// } else if (path.size() == 4 || start == digit.length) {
	// return;
	// }
	// StringBuilder result = new StringBuilder();
	// for (int i = 0; i < 3 && i + start < digit.length; i++) {
	// result.append(digit[i + start]);
	// int tmp = 0;
	// if ((tmp = Integer.valueOf(result.toString())) < 256) {
	// path.add(tmp);
	// }
	// 回溯(results, path, digit, i + start + 1);
	// System.out.println(path.toString());
	// // result.deleteCharAt(result.length() - 1);
	// }
	// }
}
