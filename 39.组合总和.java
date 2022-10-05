import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=39 lang=java
 * TOP solution 解释胃模板方法
 * [39] 组合总和
 */

// @lc code=start
class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (Objects.isNull(candidates)) {
			return new ArrayList<>();
		}
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(results, new ArrayList<>(), candidates, target, 0);
		results.stream().forEach(System.out::print);
		return results;
	}

	public void backtrack(List<List<Integer>> results, List<Integer> result, int[] nums, int remain, int start) {
		if (0 == remain) {
			results.add(new ArrayList<>(result));
			return;
		}

		if (remain < 0){
			return;
		}

		for (int i = start; i < nums.length; i++) {
			result.add(nums[i]);
			System.out.println(i + "|" + result);
			backtrack(results, result, nums, remain - nums[i], i);
			System.out.println(i + "|" + result);
			result.remove(result.size() - 1);
			System.out.println(i + "|" + result);
			System.out.println("========");
		}

	}
}
// @lc code=end
