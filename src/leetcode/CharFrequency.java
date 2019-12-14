/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.leetcode;

/**
 * @author yan.zhang
 * @date 2019/8/19 23:18
 */

import java.util.*;

/**
 * 字符串内字符都在ascci码中，给定一段字符串 返回字符出现频率最高的字符，如果出现频率一样，返回第一个字符
 */
public class CharFrequency {
    public static void main(String[] args) {
        findMapMaxValue("ddddaaaabbcee");
    }

    private static Map<Character, Integer> mapFunction(String str) {
        //保证hashMap有序
        Map<Character, Integer> map = new LinkedHashMap<>();
        if (null != str && str.length() != 0) {
            for (int i = 0; i < str.toCharArray().length; i++) {
                Integer count = map.get(str.charAt(i));
                if (null == count) {
                    map.put(str.charAt(i), 1);
                } else {
                    map.put(str.charAt(i), count + 1);
                }
            }
        }
        return map;
    }

    private static void findMapMaxValue(String str) {
        Map<Character, Integer> map = mapFunction(str);
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        Map.Entry<Character, Integer> next = it.next();
        //假设第一个为最大key,最大value
        Character maxK = next.getKey();
        Integer maxV = next.getValue();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> temp = it.next();
            if (temp.getValue() > maxV) {
                maxV = temp.getValue();
                maxK = temp.getKey();
            }
        }
        System.out.println("maxKey is "+maxK+"  "+ "maxValue is :" + maxV);
    }

}
