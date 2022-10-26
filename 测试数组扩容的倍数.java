import java.util.ArrayList;
import java.util.List;

/**
 * 初始化10
 * oldCapacity >> 1      preferred growth 每次增加到1.5倍
 */
public class 测试数组扩容的倍数 {
	public static void main(String[] args) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			results.add(Integer.valueOf(i));
		}
	}
}
