/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时
 * 折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2
 * 次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。给定一
 * 个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。
 * 例如：N=1时，打印： down N=2时，打印： down down up
 */
public class 微软等大厂的面试题之二叉树的折纸问题 {
    public static void main(String[] args) {
        打印所有的折纸(4); // 折4下
    }

    /**
     * 当前你来到了一个节点，你脑中想象的
     * 这个节点在i层,一共在N层，N固定不变的
     * 这个节点如果是凹的话，down = T
     * 这个节点如果是凸的话，down = F
     * 
     * 这里的节点指的是折痕。
     * 
     * 函数的功能：
     * 中序遍历，打印以你想像的节点为头的整棵树
     */
    public static void 打印所有的折纸(int n) {
        process(1, n, true);
    }

    public static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.print(down ? "凹" : "凸");
        process(i + 1, n, false);
    }
}
