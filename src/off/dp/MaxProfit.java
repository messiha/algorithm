package src.off.dp;

/**
 * @author yan.zhang
 * @date 2020/12/25 15:19
 */
public class MaxProfit {
    /**
     * 假设你有一个数组，其中第i个元素是股票在第 i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     * 输入：[1,4,2] 返回：3
     * 输入：[2,4,1] 返回：2
     */
    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 2};
        System.out.println(greed(arr));
        System.out.println(solution2(arr));
    }

    private static int greed(int[] arr) {
        if (arr.length < 2) return 0;
        int min = arr[0];
        int profile = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            profile = Math.max(profile, arr[i] - min);
        }
        return profile;
    }

    private static void solution(int[] arr) {
        int res = 0;
        //dp[i] 代表第i天卖出的最大收益，res = (第i-1天为止的收益+当天收益)
        int[] dp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {


        }
    }


    private static int solution2(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

}
