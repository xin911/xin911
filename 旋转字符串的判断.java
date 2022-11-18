/**
 * (s1+s1).contains(str2)
 */
public class 旋转字符串的判断 {
    public static void main(String[] args) {
        //
        String str1 = "123456";
        String str2 = "345612";

        boolean 是否是旋转字符串 = 判断是否是旋转字符串(str1, str2);
        System.out.println(是否是旋转字符串);
    }

    private static boolean 判断是否是旋转字符串(String str1, String str2) {
        return (str1 + str1).contains(str2);
    }
}
