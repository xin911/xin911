import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树代表公司结构，每个人有个快乐值，发请柬来参加聚会，直接上下级的不能邀请，返回最大的快乐值
 */
public class 多叉树的应用计算最大快乐值 {
    public static void main(String[] args) {
        员工多叉树 员工 = new 员工多叉树();
        信息 整棵树的信息 = 返回最大的快乐值(员工);
        // 最大的收益，是最大的老板来的时候，或者最大的老板不来的收益进行对比
        int 最大收益 = Math.max(整棵树的信息.yes, 整棵树的信息.no);
        System.out.println("最大收益: " + 最大收益);
    }

    public static 信息 返回最大的快乐值(员工多叉树 员工) {
        if (员工 == null) {
            return new 信息(0, 0);
        }

        int no = 0;
        int yes = 员工.快乐值;

        for (员工多叉树 next : 员工.nexts) {
            信息 nextinfo = 返回最大的快乐值(next);
            no += Math.max(nextinfo.no, nextinfo.yes);
            yes += nextinfo.no;
        }

        return new 信息(no, yes);
    }
}

/**
 * 多叉树的数据结构
 */
class 员工多叉树 {
    int 快乐值;
    List<员工多叉树> nexts = new ArrayList<>();
}

class 信息 {
    public int no;
    public int yes;

    public 信息(int no, int yes) {
        this.no = no;
        this.yes = yes;
    }
}
