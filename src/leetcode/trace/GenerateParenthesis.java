package src.leetcode.trace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2022/3/12 20:08
 */
public class GenerateParenthesis {
    /**
     * https://leetcode-cn.com/problems/generate-parentheses/
     * 括号生成
     */
    public static void main(String[] args) {
        solution(2);
    }

    private static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs(result, "", n, n);
        return result;
    }

    /**
     * 1.left > 0 可以使用左括号
     * 2.使用右括号的条件：右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量
     * 3.在左边和右边剩余的括号数都等于 0 的时候结算
     *
     * @param result
     * @param path
     * @param left
     * @param right
     */
    private static void dfs(List<String> result, String path, int left, int right) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        if (left == 0 && right == 0) {
            result.add(path);
            return;
        }

        if (right < left) {
            return;
        }

        if (left > 0) {
            dfs(result, path + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(result, path + ")", left, right - 1);
        }

    }
}
