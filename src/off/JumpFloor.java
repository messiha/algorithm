/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/3 18:26
 */

/**
 * 一次可以跳一级台阶,也可以跳两级，求青蛙跳上一个n级的台接共有多少种跳法(先后顺序不同算不同结果)
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(jumpFloorAbnormal2(4));
    }

    /**
     * 思路一：
     * level = 1 => res = 1
     * level = 2 => res = 2
     * level = 3 => res = 3
     * level = 4 => res = 5
     * ....
     * f(n) =  f(n-1) + f(n-2)
     * <p>
     * 思路二：
     * 1,2,3,5.....n-2,n-1,n
     * 假设青蛙在第n级台阶上，如果跳一步，则青蛙还有有f(n-1)种跳法，如果跳两步，则还有f(n-2)种跳法
     * 则一共有 f(n-1) + f(n-2)种跳法
     * <p>
     * 备注：当处于n-1层 跳到n层，只能跳一步，会有f(n-1)种方式，因为最后一次只能跳一步()，所以
     * 到n层的方式种数 只和到n-1层，n-2层有多少种方式有关（在n-1层无论有多少种方式，最后都是跳一次到达n层，不会产生新的跳上第n层的方式）
     */
    private static int solution(int level) {
        if (level <= 2) {
            return level;
        }
        int a = 2;
        int b = 1;
        int res = 0;
        //i in range (3,level +1)
        for (int i = 3; i < level + 1; i++) {
            res = a + b;
            b = a;
            a = res;
        }
        return res;
    }


    /**
     * 变态跳台阶：一次可以跳一级，也可以跳两级...也可以跳N级，求该青蛙跳上一个N级的台阶共有多少种跳法
     * level = 1 => res = 1
     * level = 2 => res = 2
     * level = 3 => res = 4
     * level = 4 => res = 8  => f(4) = f(4-4)+f(4-3)+f(4-2)+f(4-1)
     * ...
     * <p>
     * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     * f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     * f(n) = 2*f(n-1)
     */
    private static int jumpFloorAbnormal1(int level) {
        if (level == 1) return level;
        int a = 1;
        int res = 0;
        for (int i = 2; i < level + 1; i++) {
            res = 2 * a;
            a = res;
        }
        return res;
    }

    private static int jumpFloorAbnormal2(int level) {
        if (level == 0) {
            return -1;
        } else if (level == 1) {
            return 1;
        } else {
            return 2 * jumpFloorAbnormal2(level - 1);
        }
    }
}
