public class 判断相同的树 {
    public static void main(String[] args) {

    }

    public boolean 判断相同(树节点 第一棵树, 树节点 第二棵树) {
        if (第一棵树 == null ^ 第二棵树 == null) {
            return false;
        }

        if (第一棵树 == null && 第二棵树 == null) {
            return true;
        }

        return 第一棵树.val == 第二棵树.val && 判断相同(第一棵树.左节点, 第二棵树.左节点) && 判断相同(第一棵树.右节点, 第二棵树.右节点);
    }
}

/**
 * 
 * 遍历树，有自己的顺序
 * 1 先序遍历
 * 头 左 右
 * 2 中序遍历
 * 左 头 右
 * 3 后续便利
 * 左 右 头
 */
class 树节点 {
    public int val;
    public 树节点 左节点;
    public 树节点 右节点;
}