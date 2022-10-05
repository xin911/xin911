import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (Objects.isNull(candidates)) {
			return new ArrayList<>();
		}

		Arrays.sort(candidates);
		// int end = 去重(candidates);
		int end = candidates.length;
		Arrays.stream(candidates).forEach(System.out::print);
		System.out.println("end:" + end);
		List<List<Integer>> results = new ArrayList<>();
		backtrack(results, new ArrayList<Integer>(), candidates, target, 0, end);
		System.out.println(results);
		return results;
	}

	public int 去重(int[] candidates) {
		if (candidates.length == 1) {
			return 0;
		}
		int left = 0;
		int right = 0;
		for (; right < candidates.length;) {
			if (right >= candidates.length) {
				return left;
			}
			if (candidates[left] == candidates[right]) {
				right++;
				continue;
			}
			candidates[++left] = candidates[right];
		}
		return left + 1;
	}

	public void backtrack(List<List<Integer>> results, List<Integer> result, int[] candidates, int remain, int start,
			int end) {
		if (remain == 0) {
			results.add(new ArrayList<>(result));
			return;
		}

		if (remain < 0) {
			return;
		}

		for (int i = start; i < end; i++) {
			// System.out.println(i > start ^ result.contains(candidates[i]));
			if (remain - candidates[i] < 0) {
				return;
			}
			if (i > start && candidates[i - 1] == candidates[i]) {
				continue;
			}
			result.add(candidates[i]);
			backtrack(results, result, candidates, remain - candidates[i], i + 1, end);
			result.remove(result.size() - 1);
		}
	}
}
// @lc code=end
