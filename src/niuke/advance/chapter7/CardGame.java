/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter7;

/**
 * @author yan.zhang
 * @date 2020/11/26 21:34
 */

/**
 * 有一个整型数组A，代表数值不同的纸牌排成一条线。玩家a和玩家b依次拿走每张纸牌，规定玩家a先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸 牌，玩家a和玩家b都绝顶聪明，他们总会采用最优策略。请返回最后获胜者的分数。
 */
public class CardGame {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 4};
        System.out.println(win1(arr));
    }

    /**
     * F(arr, l , r)表示对于数组arr，元素从l到r，先拿可以达到的最大分数；
     * S(arr, l, r)表示对于数组arr, 元素从l到r，后拿可以达到的最大分数。
     *
     * @param arr
     */

    private static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 后拿函数
     * 若A先拿，剩下[i+1,j] 或[i,j-1]的范围给B拿，则后拿函数一定返回改区间最小值
     * <p>
     * baseCase：如果是一张纸牌，后拿的人什么都拿不到，返回0
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    /**
     * 先拿函数
     */
    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }
}
