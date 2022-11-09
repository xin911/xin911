import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 二叉树最大宽度(root);
    }

    public int 二叉树最大宽度(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int max = queue.size();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left
        }
    }
}
// @lc code=end
