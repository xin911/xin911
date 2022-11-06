import java.util.Arrays;
import java.util.stream.Collectors;

public class 归并排序随笔 {
	public static void main(String[] args) {
		// int[] para = new int[] { 1, 3, 4, 2, 6, 5, 7, 8 };
		int[] para = new int[] { 1, 3, 4, 2 };
		System.out.println("3 + 4 - 3 >> 1 : " + (3 + 4 - 3 >> 1));
		System.out.println("3 + (4 - 3) >> 1 : " + (3 + (4 - 3) >> 1));
		System.out.println("3 + ((4 - 3) >> 1) : " + (3 + ((4 - 3) >> 1)));
		归并排序(para);
		// systemarraycopy比遍历循环快
		// 测试systemarraycopy();
	}

	public static void 归并排序(int[] nums) {
		if (nums == null) {
			return;
		}
		归并排序(nums, 0, nums.length - 1);
	}

	public static void 归并排序(int[] nums, int start, int end) {
		if (start == end) {
			return;
		}

		// int middle = (start + end) >> 2;
		int middle = start + ((end - start) >> 1);
		归并排序(nums, start, middle);
		归并排序(nums, middle + 1, end);
		归并排序(nums, start, middle, end);

	}

	public static void 归并排序(int[] nums, int start, int middle, int end) {
		int[] result = new int[end - start + 1];
		int i = 0;
		// 增加三指针 数组一般都要增加双指针的
		int left = start;
		int right = middle + 1;
		// 这里使用&&而不是||,满足左或者右任何一个条件就可以了。
		while (left <= middle && right <= end) {
			result[i++] = nums[left] <= nums[right] ? nums[left++] : nums[right++];
		}

		if (left <= middle) {
			// result[i++] = nums[left++];
			System.arraycopy(nums, left, result, i, middle - left + 1);
		}

		if (right <= end) {
			// result[i++] = nums[right++];
			System.arraycopy(nums, right, result, i, end - right + 1);
		}

		// for (int j = 0; j < result.length; j++) {
		// nums[start + j] = result[j];
		// }
		System.arraycopy(result, 0, nums, start, result.length);
		System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(",")));
	}

	/**
	 * 对于数组，在内存中有优化，直接拷贝内存？
	 * for loop: 47
	 * System.arrayCopy: 24
	 * 
	 * for loop: 31
	 * System.arrayCopy: 22
	 * 
	 * for loop: 36
	 * System.arrayCopy: 22
	 * 所以，Bragboy 是正确的。
	 */
	public static void 测试systemarraycopy() {
		for (int count = 0; count < 3; count++) {
			int size = 0x00ffffff;
			long start, end;
			Integer[] integers = new Integer[size];
			Integer[] loopCopy = new Integer[size];
			Integer[] systemCopy = new Integer[size];

			for (int i = 0; i < size; i++) {
				integers[i] = i;
			}

			start = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				loopCopy[i] = integers[i];
			}
			end = System.currentTimeMillis();
			System.out.println("for loop: " + (end - start));

			start = System.currentTimeMillis();
			System.arraycopy(integers, 0, systemCopy, 0, size);
			end = System.currentTimeMillis();
			System.out.println("System.arrayCopy: " + (end - start));
		}
	}
}
