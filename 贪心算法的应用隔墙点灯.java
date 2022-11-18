/**
 * 头条现场原题：
 * 贪心算法的应用隔墙点灯
 * 
 * 给定字符串，由X和.构成
 * X表示墙，不能放灯，也不需要点亮
 * .代表居民点，能放灯，也可以点亮
 * 如果灯放在i位置，那么i-1，i，i+1三个位置可以被点亮
 * 
 * 贪心的问题，是最多的方式见过这个题，积累经验
 */
public class 贪心算法的应用隔墙点灯 {

	public static void main(String[] args) {
		String 墙和灯 = "X...X..X...X";
		int cnt = 最少放灯位置(墙和灯);
	}

	private static int 最少放灯位置(String 墙和灯) {
		char[] 位置 = 墙和灯.toCharArray();
		int i = 0;
		int light = 0;
		while (i < 位置.length) {
			if (位置[i] == 'X') {
				i++;
			} else {
				light++;
				if (i + 1 == 位置.length) {
					break;
				} else {
					if (位置[i + 1] == 'X') { // 如果是.X这种，i标记为跳过去。灯数加1
						i = i + 2;
					} else {
						// i不是X，i+1不是X，那么灯应该放在i+1.
						// .X..
						i = i + 3;
					}
				}
			}
		}
		return light;

	}

}