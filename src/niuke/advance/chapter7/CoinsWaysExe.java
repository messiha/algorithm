package src.niuke.advance.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2020/11/25 下午3:05
 */
public class CoinsWaysExe {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2};
        int aim = 15;
        System.out.println(baseSolution(arr, aim));
        System.out.println(solutionByDp(arr, aim));

    }

    private static int baseSolution(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return process(arr, 0, aim);
    }


    private static int solutionByDp(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return processByDp(arr, 0, aim);
    }


    private static int processByDp(int[] arr, int index, int aim) {
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


    private static final Map<String, Integer> MAP = new HashMap<>(16);


    private static int process(int[] arr, int index, int aim) {
        int res = 0;

        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

}
