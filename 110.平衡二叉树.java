/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    /**
     * 平衡树的定义
     * 1、每一颗子树，|左高-右高| <= 1
     * 
     * 给定一棵树判断是否是平衡树，那么
     * 1、左树是平衡树、
     * 2、右树是平衡树
     * 如果有一方不是平衡树，那么整体就不是平衡树
     * 需要借助递归的属性，并且同时记录每个树节点的树高
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return 判断是否是平衡二叉树(root).isBalanced;
    }

    public Treeinfo 判断是否是平衡二叉树(TreeNode head) {
        if (head == null) {
            return new Treeinfo(0, true);
        }
        Treeinfo left = 判断是否是平衡二叉树(head.left);
        Treeinfo right = 判断是否是平衡二叉树(head.right);

        return new Treeinfo(Math.max(left.height, right.height) + 1,
                left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1 ? true : false);

    }
}

class Treeinfo {
    int height;
    boolean isBalanced;

    public Treeinfo() {
    }

    public Treeinfo(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
// @lc code=end
