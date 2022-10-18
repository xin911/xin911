import java.util.Objects;

public class 三有序数组中找到num {

    public static void main(String[] args) {
        boolean result = 查找数组中的元素(结果的对数器.生成数组(10, 15), 10);
        System.out.println();
        System.out.println(result);
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

    public static int 查找符合条件的最左位置() {
        return 0;
    }
}
