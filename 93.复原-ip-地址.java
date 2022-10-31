import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
	public List<String> restoreIpAddresses(String s) {
		if (Objects.isNull(s)) {
			return new ArrayList<>();
		}

		List<List<String>> results = new ArrayList<>();
		List<String> result = new ArrayList<>();
		backtrack(results, result, s.toCharArray(), 0);
		List<String> ips = results.stream().map(e -> e.stream().collect(Collectors.joining(".")))
				.collect(Collectors.toList());
		return ips;
	}

	public void backtrack(List<List<String>> results, List<String> result, char[] digit, int start) {
		results.add(result);
		for (int i = start; i < digit.length; i++) {
			result.add(String.valueOf(digit[i]));
			backtrack(results, result, digit, start + 1);
			result.remove(result.size() - 1);
		}
	}
}
// @lc code=end
