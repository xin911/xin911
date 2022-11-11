/**
 * 1 左满 右满 左高==右高
 * 2 左完 右满 左高==右高 + 1
 * 3 左满 右满 左高==右高 + 1
 * 4 左满 右完 左高==右高
 */
public class 判断是完全二叉树 {
	public static void main(String[] args) {
		// 是否完全二叉树
	}

	public static boolean 是否完全二叉树(TreeNode head) {
		return 深度遍历(head).是否完全;
	}

	public static 信息 深度遍历(TreeNode head) {
		if (head == null) {
			return new 信息(true, true, 0);
		}

		信息 左 = 深度遍历(head.left);
		信息 右 = 深度遍历(head.right);

		int 高度 = Math.max(左.高度, 右.高度) + 1;
		boolean 是否满的 = 左.是否满的 && 右.是否满的 && 左.高度 == 右.高度;
		boolean 是否完全 = false; // 先默认false，因为一共是四种情况
		// 1 左树是满的，右树是满的，左树高度==右树高度
		if (左.是否满的 && 右.是否满的 && 左.高度 == 右.高度) {
			是否完全 = true;
		}
		// 2
		else if (左.是否完全 && 右.是否满的 && 左.高度 == 右.高度 + 1) {
			是否完全 = true;
		}
		// 3
		else if (左.是否满的 && 右.是否满的 && 左.高度 == 右.高度 + 1) {
			是否完全 = true;
		}
		// 4
		else if (左.是否满的 && 右.是否完全 && 左.高度 == 右.高度) {
			是否完全 = true;
		}
		return new 信息(是否满的, false, 高度);
	}
}

class 信息 {
	public boolean 是否满的;
	public boolean 是否完全;
	public int 高度;

	/**
	 * @param 是否满的
	 * @param 是否完全
	 * @param 高度
	 */
	public 信息(boolean 是否满的, boolean 是否完全, int 高度) {
		this.是否满的 = 是否满的;
		this.是否完全 = 是否完全;
		this.高度 = 高度;
	}
}