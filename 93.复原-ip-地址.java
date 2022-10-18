import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (Objects.isNull(s)) {
            return new ArrayList<>();
        }

        List<String> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        backtrack(results, result, s.toCharArray(), 0);
        return results;
    }

    public void backtrack(List<String> results, List<String> result, char[] digit, int start) {
        
        if (Character.isDigit(digit[start])) {

        }
    }
}
// @lc code=end
