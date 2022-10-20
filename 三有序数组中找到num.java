import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class 三有序数组中找到num {

	public static void main(String[] args) {
		boolean result = 查找数组中的元素(结果的对数器.生成数组(10, 15), 10);
		System.out.println();
		System.out.println(result);
		System.out.println(查找符合条件的最左位置(new int[] { 1, 2, 3, 4, 4, 4, 5, 5, 6 }, 4));
		System.out.println();
		System.out.println(
				Arrays.stream(相邻不相等的随机数组(10, 12)).boxed().map(String::valueOf).collect(Collectors.joining(",")));
		System.out.println();
		测试查找数组中的下降区间();
		// int some = sometest(new int[] { 7, 5, 17, 11, 20 });
		// int 下降区间 = 查找数组中的下降区间(new int[] { 7, 5, 17, 11, 20 });
		// System.out.println(some + ":" + 下降区间);
	}

	private static void 测试查找数组中的下降区间() {
		System.out.println("开始");
		for (int i = 0; i < 10000; i++) {
			int[] 随机数组 = 相邻不相等的随机数组(5, 20);
			打印数组(随机数组);
			int 最小数字 = 查找数组中的下降区间(随机数组);
			if (!验证左右数字是不是比自己大(随机数组, 最小数字)) {
				// 打印数组(随机数组);
				System.err.println("最小数字有错: " + 最小数字);
				break;
			}
		}
		System.out.println("结束");
	}

	public static boolean 查找数组中的元素(int arr[], int num) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return false;
		}
		for (int cnt : arr) {
			System.out.print(cnt);
		}
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int middle = (left + right) >> 2;
			if (arr[middle] == num) {
				return true;
			} else if (arr[middle] < num) {
				right = middle - 1;
			} else if (arr[middle] > num) {
				left = middle + 1;
			}
		}
		return false;
	}

	public static int 查找符合条件的最左位置(int[] 数组, int 目标数字) {
		return 查找符合条件的最左位置(-1, 数组, 目标数字, 0, 数组.length - 1);
	}

	/**
	 * 2345 4
	 * 
	 * @param result <B>返回结果需要是一个对象地址。如果是基本类型，那么赋值是无效的.</B>
	 *               简言之，int不行,Integer也不可以使用Integer.vlaueOf也不行。
	 * @param 数组
	 * @param 目标数字
	 * @param start
	 * @param end
	 */
	public static int 查找符合条件的最左位置(int result, int[] 数组, int 目标数字, int start, int end) {
		if (start > end) {
			return result;
		}
		int middle = (start + end) >> 1;
		if (数组[middle] < 目标数字) {
			start = middle + 1;
		} else {
			end = middle - 1;
			result = middle;
		}
		return 查找符合条件的最左位置(result, 数组, 目标数字, start, end);
	}

	/**
	 * 32145
	 * 
	 * @param arr
	 * @return
	 */
	public static int 查找数组中的下降区间(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return 0;
		}

		if (arr[0] < arr[1]) {
			return 0;
		}

		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}

		return 查找数组中的下降区间(-1, arr, 0, arr.length - 1);
	}

	/**
	 * 32145
	 * 
	 * @param result
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int 查找数组中的下降区间(int result, int[] arr, int start, int end) {
		if (start > end) {
			return result;
		}
		int middle = (start + end) >> 1;
		if (arr[middle - 1] > arr[middle] && arr[middle] < arr[middle + 1]) {
			result = middle;
			return result;
		}
		// 不同时小
		// 2 start > middle > end
		// 1 start < middle < end
		// 3 start < middle > end
		// 4 start == middle == end

		// 1、3场景 因为左侧小，说明左侧一定有最小区间，所以不管右面有或者没有，都忽略掉右
		if (arr[middle - 1] < arr[middle]) {
			end = middle;
		} else

		// 2、3场景。因为右侧小，说明右侧一定存在最小区间，所以不管左面有或者没有，都忽略掉左。
		if (arr[middle] > arr[middle + 1]) {
			start = middle + 1;
		}
		return 查找数组中的下降区间(result, arr, start, end);
	}

	private static int[] 相邻不相等的随机数组(int 最大长度, int 最大值) {
		if (最大长度 < 1) {
			return new int[] {};
		}
		int 随机长度 = Double.class.cast(Math.random() * (最大长度 + 1)).intValue();
		int 随机数组[] = new int[随机长度];
		System.out.println("随机长度" + 随机长度 + ", 数组长度:" + 随机数组.length);
		if (随机长度 != 0) {
			随机数组[0] = Double.class.cast(Math.random() * (最大值 + 1)).intValue();
		}
		for (int i = 1; i < 随机长度; i++) {
			do {
				随机数组[i] = Double.class.cast(Math.random() * (最大值 + 1)).intValue();
			} while (随机数组[i - 1] == 随机数组[i]);
		}
		return 随机数组;
	}

	/**
	 * 如果数组的序号越界了，那么认为不破坏规则
	 * 
	 * @param 数组
	 * @param 最小值序号
	 * @return
	 */
	private static boolean 验证左右数字是不是比自己大(int[] 数组, int 最小值序号) {
		if (数组 == null || 数组.length == 0) {
			return 最小值序号 == -1;
		}
		int left = 最小值序号 - 1;
		int right = 最小值序号 + 1;
		boolean 左侧大 = left >= 0 ? 数组[left] > 数组[最小值序号] : true;
		boolean 右侧大 = right < 数组.length ? 数组[right] > 数组[最小值序号] : true;
		return 左侧大 && 右侧大;
	}

	private static void 打印数组(int[] 数组) {
		System.out.println(Arrays.stream(数组).boxed().map(String::valueOf).collect(Collectors.joining(",")));
	}

	private static int sometest(int[] 数组) {
		int ans = -1;
		int left = 0;
		int right = 数组.length - 1;
		while (left <= right) {
			int middle = (left + right) >> 1;
			if (数组[middle] < 数组[middle - 1] && 数组[middle] < 数组[middle + 1]) {
				ans = middle;
				break;
			}

			if (数组[middle - 1] < 数组[middle]) {
				right = middle;
				continue;
			}

			if (数组[middle] > 数组[middle + 1]) {
				left = middle;
				continue;
			}
		}
		return ans;
	}
}
