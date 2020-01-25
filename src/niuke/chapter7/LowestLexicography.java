/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7;

/**
 * @author yan.zhang
 * @date 2020/1/25 16:55
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字典序：
 * 1.当两个字符串长度相等，直接比较
 * 2.两个字符串长度不等，长度短的用最小的ascii码填充到长度一致，再比较
 * <p>
 * 贪心：定义指标，将每一个样本按指标划分。根据指标优先级处理
 */
public class LowestLexicography {  //按最小字典序将字符串数组排序
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            //负数：s1+s2 字典序小于s2+s1
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator()); //排序后字典序升序
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"jibw", "jb", "jp", "bw"};
        System.out.println(LowestLexicography.lowestString(strs));
    }
}
