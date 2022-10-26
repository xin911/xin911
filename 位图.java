import java.util.HashSet;

public class 位图 {
	private long[] bits;

	public 位图(int 最大值) {
		/**
		 * num >> 6
		 * 用来代替num / 64
		 */
		bits = new long[(最大值 + 64) >> 6];
	}

	public void add(int num) {
		/**
		 * num & 63
		 * 用来代替num % 64
		 * 例如：
		 * 170
		 * 170 % 64 == 170 & 63 == 42 == 1 << 42
		 * 相当于标记
		 * bits[2] = bits[2] | 42
		 * bits[2] = bits[2] | 1 << 42
		 * 将[2, 42] 至1
		 */
		bits[num >> 6] |= 1L << (num & 63);
	}

	public void delete(int num) {
		/*
		 * 例如:
		 * "~"取反运算符
		 * 将[2,42] 至 0， 不管原来是什么值
		 * 1011 0110 11
		 * 变成1011 0100 11
		 * 先构建
		 * 0000 0010 00
		 * 1111 1101 11
		 * 
		 * 然后使用"&"运算符
		 * 得到1011 0100 11
		 */
		bits[num >> 6] &= ~(1L << (num & 63));
	}

	public boolean contains(int num) {
		/**
		 * 必须1L进行位移运算
		 * 如果使用1进行位运算 1<<63, 会有问题。
		 * 因为1是整形，只有32位。
		 * 这里需要细心注意
		 */
		return (bits[num >> 6] & (1L << (num & 63))) != 0;
	}

	public static void main(String[] args) {
		System.out.println("测试开始");
		int max = 10000;
		位图 bits = new 位图(max);
		HashSet<Integer> hashSet = new HashSet<>();
		int testTimes = 100000;
		for (int i = 0; i < testTimes; i++) {
			int num = Double.class.cast(Math.random() * max + 1).intValue();
			double decide = Math.random();
			if (decide < 0.333) {
				bits.add(num);
				hashSet.add(num);
			} else if (decide < 0.666) {
				bits.delete(num);
				hashSet.remove(num);
			} else {
				if (bits.contains(num) != hashSet.contains(num)) {
					System.out.println("有错误");
					break;
				}
			}
		}

		for (int num = 0; num < max; num++) {
			if (bits.contains(num) != hashSet.contains(num)) {
				System.out.println("有错误");
				break;
			}
		}
		System.out.println("测试结束");
	}

	/**
	 * 使用位运算，计算加减乘除
	 * 计算机加减乘除符号的底层逻辑
	 * 
	 * 关于运行效率。单纯的位运算速度是很快的，
	 * 但是jvm对符号的加减乘除有优化
	 * 
	 * 不能用加号
	 */
	public int 位运算加法(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b; // 无进位相加信息 -> sum
			b = (a & b) << 1; // 进位信息 -> b - b'(进位信息)
			a = sum; // a -> a' 无进位相加信息
		}
		return sum;
	}

	/**
	 * 
	 */
	public int 位运算相反数(int n) {
		return 位运算加法(~n, 1);
	}

	/**
	 * 
	 */
	public int 位运算减法(int a, int b) {
		return 位运算加法(a, 位运算相反数(b));
	}

	public int 位运算乘法(int a, int b) {
		int result = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				result = 位运算加法(result, a);
			}
		}
		a <<= 1;
		b >>>= 1;
		return result;
	}

	public boolean 位运算判断是否负数(int n) {
		return n < 0;
	}

	public int 位运算除法(int a, int b) {
		int x = 位运算判断是否负数(a) ? 位运算相反数(a) : a;
		int y = 位运算判断是否负数(b) ? 位运算相反数(b) : b;
		int result = 0;
		// x/y
		for (int i = 30; i >= 0; i = 位运算减法(i, 1)) {
			if ((x >> i) >= y) {
				result |= (1 << i);
				x = 位运算减法(x, y << i);
			}
		}
		return 位运算判断是否负数(a) ^ 位运算判断是否负数(b) ? 位运算相反数(result) : result;
	}

}
