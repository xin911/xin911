import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();
        中序遍历求和(results, new ArrayList<>(), root, 0, targetSum);
        System.out.println(results.toString());
        return results;
    }

    public void 中序遍历求和(List<List<Integer>> results, List<Integer> result, TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            results.add(new ArrayList<>(result));
        }
        中序遍历求和(results, result, root.left, sum + root.val, targetSum);
        中序遍历求和(results, result, root.right, sum + root.val, targetSum);
        result.remove(result.size() - 1);
    }
}
// @lc code=end
