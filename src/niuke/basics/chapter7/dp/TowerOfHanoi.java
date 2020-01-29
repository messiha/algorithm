/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 14:11
 */

/**
 * 汉诺塔问题
 * 在最左侧有N层,如何全部移动到最右侧，打印步骤
 * 思路：抽象问题 from to help 分别代表 左，右，中三个杆
 * 问题本质是从from上移走全部到to
 * 1) 1~n-1 从from移动到help
 * 2) n 从from移动到to
 * 3) 1~n-1从from移动到to
 */
public class TowerOfHanoi {
    /**
     * @param N    代表1~N的问题
     * @param from
     * @param to
     * @param help
     */
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {// 1~1的问题，代表已经是最下层，直接从from移动到to
            System.out.println("Move 1 from " + from + " to" + to);
        } else { //1~n的问题
            process(N - 1, from, help, to);
            System.out.println("Move " + N + " from " + from + " to" + to);
            process(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        process(3, "左", "右", "中");
    }
}
