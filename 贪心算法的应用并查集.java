import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {A}, {B}, {C}, {D}, {E}, {F},{G}
 * 1、判断集合相同
 * 2、union并集
 * O(1)的时间复杂度
 * 
 */
public class 贪心算法的应用并查集 {

	public static void main(String[] args) {

	}

}

class 集合包装类<V> {
	V v;

	public 集合包装类(V v) {
		this.v = v;
	}
}

/**
 * 使用3个map，作为存放集合间的指针
 * 1、当前节点
 * 2、父节点
 * 3、集合大小
 */
class 并查集合<V> {
	Map<V, 集合包装类<V>> nodes = new HashMap<>();
	Map<集合包装类<V>, 集合包装类<V>> parents = new HashMap<>();
	/**
	 * 只有头节点才存有size
	 */
	Map<集合包装类<V>, Integer> sizemap = new HashMap<>();

	public 并查集合(List<V> values) {
		for (V v : values) {
			集合包装类<V> node = new 集合包装类<>(v);
			nodes.put(v, node);
			parents.put(node, node);
			sizemap.put(node, 1);
		}
	}

	private boolean 判断是否包含集合(集合包装类 o1, 集合包装类 o2) {
		return false;
	}

	private 集合包装类<V> 求并集(集合包装类 o1, 集合包装类 o2) {
		return null;
	}
}