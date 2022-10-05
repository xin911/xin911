/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

/**
 * 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
 */
// @lc code=start
class Solution {
	public int jump(int[] nums) {
		int step = 0; // 跳跃次数
		int max = 0; // 目前能跳到的最远位置
		int edge = 0; // 上次跳跃可达范围右边界（下次的最右起跳点）
		/**
		 * 这里要注意
		 * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素
		 * 
		 * 作者：LeetCode-Solution
		 * 链接：https://leetcode.cn/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
		 * 来源：力扣（LeetCode）
		 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		 */
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(i + nums[i], max); // 跳到最远胡位置
			if (i == edge) {
				edge = max; // 目前能跳到的最远位置变成了下次起跳位置的有边界
				step++; // 进入下一次跳跃
			}
		}
		return step;
	}
}
// @lc code=end
