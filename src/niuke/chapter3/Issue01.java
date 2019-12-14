/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter3;

/**
 * @author yan.zhang
 * @date 2019/10/6 17:25
 */

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N),且要求不能用非基于比较的排序
 * 思路：使用"桶"的概念，但是不使用桶排序
 * <p>
 * 0.数组长度为N,准备N+1个桶
 * 1.遍历数组，找出最大值最小值
 * 2.一定会有一个"空桶"
 * 3.则最大差值一定不来自桶内部 （相同桶内的数值的差值一定小于 两个非空桶之间的差值）
 */
public class Issue01 {

    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 1, 9};
        System.out.println(maxGap(arr));
    }

    public static int maxGap(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //遍历数组找寻最大值最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (max == min) {
            return 0;
        }
        /**
         * 定义 hasNums mins maxs数组分别记录0~N位置上桶内部信息
         */
        boolean[] hasNums = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNums[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNums[bid] ? Math.max(mins[bid], arr[i]) : arr[i];
            //下标为bid的桶 是否有值标记更新为true，代表有值
            hasNums[bid] = true;
        }
        int res = 0;
        //lastMax:前一个桶最大值
        int lastMax = maxs[0];
        int i = 1;
        /**
         * 遍历所有非空桶
         */
        for (; i <= len; i++) {
            if (hasNums[i]) {
                //当前桶最小值-前一个桶最大值
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }

        }
        return res;
    }

    /**
     * 定位数值来自的桶位置
     */
    private static int bucket(int num, int len, int min, int max) {
        return (num - min) * len / (max - min);
    }

}
