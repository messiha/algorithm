package src.leetcode.trace;

import java.util.*;

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
//        solution(3);
        dp(3);
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

    /**
     * 动态规划思路
     * 思路：https://www.bilibili.com/video/BV1wq4y1u7Q2?spm_id_from=333.337.search-card.all.click
     */
    private static List<String> dp(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        //定义dp[n],dp[n]代表n对括号时,所有有效括号的组合
        List<String>[] dp = new List[n + 1];
        dp[1] = new ArrayList<>();
        dp[1].add("()");

        Set<String> set = new HashSet<>();

        //计算n >= 2 情况
        for (int i = 2; i <= n; i++) {
            //1.初始化
            dp[i] = new ArrayList<>();
            //2.遍历上一级结果集 举例当n = 3 dp[2]取出的结果集为()(),(())两个
            for (int j = 0; j < dp[i - 1].size(); j++) {
                String base = dp[i - 1].get(j);
                //3.对base遍历,将()塞入base每个字符的间隙,举例 base = ()(),依次添加(),得到结果为()()(),(())()等等等
                for (int k = 0; k < base.length(); k++) {
                    String left = base.substring(0, k);
                    String right = base.substring(k);
                    String add = left + "()" + right;
                    //去重
                    if (set.add(add)) {
                        dp[i].add(add);
                    }

                }
            }
        }
        return dp[n];
    }

    /**
     * dp思路不去重版本
     *
     * @param n
     * @return
     */
    private static List<String> dp_1(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

}
