package src.xmly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author yan.zhang
 * @Date 2022/1/28 16:36
 * @Version 1.0
 */
public class PrintAllSubsequence {

    public static void main(String[] args) {
        System.out.println(subs1("abc").toString());
        System.out.println(subs2("aaa").toString());
    }

    private static List<String> subs1(String str) {
        char[] chars = str.toCharArray();
        List<String> listRes = new ArrayList<>();
        process(chars, 0, listRes, "");
        return listRes;
    }

    private static Set<String> subs2(String str) {
        char[] chars = str.toCharArray();
        HashSet<String> setRes = new HashSet<>();
        processByNoRepeat(chars, 0,setRes, "");
        return setRes;
    }

    /**
     * 所有子序列
     *
     * @param chars
     * @param index
     * @param res
     * @param path
     */
    private static void process(char[] chars, int index, List<String> res, String path) {
        if (index == chars.length) {
            res.add(path);
            return;
        }
        process(chars, index + 1, res, path);
        process(chars, index + 1, res, path + chars[index]);
    }

    /**
     * 所有子序列不包含重复
     *
     * @param chars
     * @param index
     * @param res
     * @param path
     */
    private static void processByNoRepeat(char[] chars, int index, Set<String> res, String path) {
        if (index == chars.length) {
            res.add(path);
            return;
        }
        processByNoRepeat(chars, index + 1, res, path);
        processByNoRepeat(chars, index + 1, res, path + chars[index]);
    }


}
