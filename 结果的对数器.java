public class 结果的对数器 {
    /**
     * [0, 最大值]
     * 
     * @param 最大长度
     * @param 最大值
     * @return
     */
    public static int[] 生成数组(int 最大长度, int 最大值) {
        int[] result = new int[Double.class.cast(Math.random() * (最大长度 + 1)).intValue()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.class.cast((最大值 + 1) * Math.random()).intValue();
            // System.out.println(result[i]);
            // result[i] = Double.class.cast((最大值 + 1) * Math.random()).intValue()
            // - Double.class.cast(Math.random() * 最大值).intValue();
            // System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] results = 生成数组(10, 15);
        for (int result : results) {
            System.out.println(result);
        }
        System.out.println("====");
    }
}
