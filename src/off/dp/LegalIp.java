/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.dp;

import java.util.ArrayList;

/**
 * @author yan.zhang
 * @date 2021/1/10 12:49
 */
public class LegalIp {
    /**
     * 给定一串字符串，ag：19216801 打印出所有合法的ip地址
     */
    public static void main(String[] args) {
        String ip = "19216801";
//        String ip = "1111";
        find(ip);
    }

    /**
     * 合法ip地址必须满足以下：
     * 1.ip地址是由四段组成，每段在0-255
     * 2.每段最大数字不能超过255
     * 3.第一个字节不能为0
     * <p>
     * 截止条件：
     * 1.ip字符串已经找到最后一个字符了
     * 2.四段都已经填满
     *
     * @param ip
     */
    private static void find(String ip) {
        dfs(ip, new ArrayList<>(), 0);
        System.out.println(RES.toString());
    }


    private static final ArrayList<String> RES = new ArrayList<>();


    private static void dfs(String ip, ArrayList<String> temp, int start) {
        if (temp.size() == 4 && start == ip.length()) {
            RES.add(temp.get(0) + '.' + temp.get(1) + '.' + temp.get(2) + '.' + temp.get(3));
            return;
        }

        if (ip.length() - start > 3 * (4 - temp.size())) {
            return;
        }
        if (ip.length() - start < (4 - temp.size())) {
            return;
        }

        int num = 0;
        for (int i = start; i < start + 3 && i < ip.length(); i++) {
            //check
            num = num * 10 + ip.charAt(i) - '0';

            if (num < 0 && num > 256) {
                continue;
            }

            temp.add(ip.substring(start, i + 1));

            dfs(ip, temp, i + 1);

            temp.remove(temp.size() - 1);

            if (num == 0) {
                break;
            }
        }

    }


    /*private static List<String> process(String ip, int index, int level) {
        if (level == 4 || RES.size() == ip.length() - 1) {
            if (level == 4 && RES.size() == ip.length() - 1) {

            }

        }

        for (int i = 1; i < 4; i++) {
            int end = index + 1 == ip.length() ? ip.length() : index + 1 + i;
            String sub = ip.substring(index + 1, end);
            //检查 是否在0~255范围内
            if ((!sub.startsWith("0") || "0".equals(sub)) && (!sub.isEmpty() && Integer.parseInt(sub) < 256)) {
                RES.push(sub);
                process(ip, index + i, level + 1);
                RES.pop();
            }
        }
        return RES;
    }*/
}
