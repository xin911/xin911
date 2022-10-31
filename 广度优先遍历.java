import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历，借助queue
 */
public class 广度优先遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        广度优先遍历(treeNode);
    }

    private static List<List<Integer>> 广度优先遍历(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
    }
}
