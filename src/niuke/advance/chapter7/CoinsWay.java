/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter7;

/**
 * @author yan.zhang
 * @date 2020/11/22 21:06
 */

import java.util.HashMap;

/**
 * 给定数组arr，arr中所有的值都为正数且不重复，每个值代表一种面值的货币。每种面值的货币可以使用任意张。
 * 再给定一个整数aim代表要找的钱数，求换钱有多少种方法。
 * 举例：
 * arr = [5,10,25,1] aim=0
 * 组成0元的方法有1种，即所有面值货币都不使用。所以返回1
 * arr = [3,5] aim=2
 * 任何方法都无法组成2元，所以返回0
 */
public class CoinsWay {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2};
//        int[] arr = new int[]{5, 10, 25, 1};
//        int aim = 15;
        int aim = 10;
        System.out.println(coins1(arr, aim));
        System.out.println(coins2(arr, aim));
        System.out.println(coins3(arr, aim));
    }

    private static int coins1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int coins2(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        return processByCache(arr, 0, aim);
    }

    private static int coins3(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        return processByDp(arr, 0, aim);
    }


    /**
     * 配合DP图理解
     * 推理步骤：
     * 1.找出最终目标，本例中processByDp(arr, 0, aim);  0~aim位置即为最终目标
     * 2.找出不依赖其他"位置"即可判断结果的位置，即baseCase
     * 3.推出位置依赖关系
     *
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    private static int processByDp(int[] arr, int index, int aim) {
        int[][] dp = new int[arr.length][aim + 1];

        //初始化，对于暴力递归的baseCase，当arr.length == index时可以不依赖任何"位置"得到解
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        //初始化
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        //计算dp图，从dp图的 1,1位置计算
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        //dp[arr.length - 1][aim] 最总目标坐标值
        return dp[arr.length - 1][aim];
    }

    /**
     * dp表换个方式
     */
    private static int processByDp2(int[] arr, int index, int aim) {
        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; arr[arr.length - 1] * j <= aim; j++) {
            dp[arr.length - 1][j * arr[arr.length - 1]] = 1;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }

        return dp[0][aim];
    }


    private static int process1(int[] arr, int index, int aim) {
        int res = 0;

        if (arr.length == index) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }

        return res;
    }


    /**
     * 缓存思路(记忆化搜索)：
     * 当子问题重index和aim确定，则整个问题的结果一定确定。无后效性问题
     */
    private static int processByCache(int[] arr, int index, int aim) {
        int res = 0;

        if (arr.length == index) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                //生成下一次递归的key
                int nextAim = aim - arr[index] * i;
                String key = String.valueOf(index + 1).concat("_").concat(String.valueOf(nextAim));

                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    //map中没有记录，递归计算
                    res += process1(arr, index + 1, aim - arr[index] * i);
                }
            }
        }

        //返回上层前，将当前"层"(当前index和aim下的结果) 计算后的结果保存在map，避免大量重复计算
        map.put(String.valueOf(index).concat("_").concat(String.valueOf(aim)), res);
        return res;
    }

    //key:index_aim value:参数为index_aim下的返回值
    private static HashMap<String, Integer> map = new HashMap<>();


}
