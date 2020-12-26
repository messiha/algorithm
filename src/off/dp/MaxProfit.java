package src.off.dp;

/**
 * @author yan.zhang
 * @date 2020/12/25 15:19
 */
public class MaxProfit {
    /**
     * 题目一:
     * 假设你有一个数组，其中第i个元素是股票在第 i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     * 输入：[1,4,2] 返回：3
     * 输入：[2,4,1] 返回：2
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2};
        System.out.println(greed(arr));
        System.out.println(solution2(arr));

//        int[] arr2 = new int[]{5, 4, 3, 2, 1};
        int[] arr2 = new int[]{2, 7, 4, 6, 100};
        System.out.println(solution3(arr2));

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


    /**
     * 题目二：
     * 假定你知道某只股票每一天价格的变动。
     * 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
     * 请设计一个函数，计算你所能获得的最大收益。
     */
    private static int solution3(int[] prices) {
        if (prices.length < 2) return 0;

        int res = 0;
        int buy = 0;
        int sell = 1;

        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                res += prices[sell] - prices[buy];
            }
            sell++;
            buy++;
        }

        return res;
    }

}
