/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.dp;

import java.util.ArrayList;

/**
 * @author yan.zhang
 * @date 2021/1/10 16:00
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        //[1.9.216.801, 1.92.16.801, 1.921.6.801, 1.921.680.1, 19.2.16.801, 19.21.6.801,
        // 19.21.680.1, 19.216.80.1, 192.1.6.801, 192.1.680.1, 192.16.80.1, 192.168.0.1]
//        dfs("19216801", 0);
        dfs("25525522135", 0);
//        dfs("0000", 0);
        System.out.println(RES.toString());
    }


    private static final ArrayList<String> STACK = new ArrayList<>();
    private static final ArrayList<String> RES = new ArrayList<>();

    private static void dfs(String s, int start) {
        int maxSize = (4 - STACK.size()) * 3;
        if (s.length() - start > maxSize) return;

        if (STACK.size() == 4 && start == s.length()) {
            RES.add(STACK.get(0) + '.' + STACK.get(1) + '.' + STACK.get(2) + '.' + STACK.get(3));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            //s从start位置向后截取长度为i - start + 1的字符串
            String sub = subStr(s, start, i - start + 1);
            if (isValid(sub)) {
                STACK.add(sub);
                dfs(s, i + 1);
                STACK.remove(STACK.size() - 1);
            }
        }
    }


    private static String subStr(String s, int start, int len) {
        return s.substring(start, Math.min(start + len, s.length()));
    }

    private static boolean isValid(String s) {
        if ((s.length() > 1 && s.charAt(0) == '0') || s.length() > 3) {
            return false;
        }
        if (s.isEmpty()) return false;
        return Integer.parseInt(s) > 0 && Integer.parseInt(s) < 256;
    }
}
