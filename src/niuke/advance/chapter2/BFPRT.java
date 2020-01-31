/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter2;

/**
 * @author yan.zhang
 * @date 2020/1/30 22:17
 */

/**
 * 在无序数组中找到第K小的数，或者找到第K大的数，时间复杂度O(N)
 * 1.逻辑分组
 * 2.小组排序,只保证逻辑小组间有序
 * 3.选择小组中位数组成新数组
 * 4.
 */
public class BFPRT {

    private static int getMinKthByBFPRT(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    /**
     * 在[begin,end]范围求第k小的数
     *
     * @return
     */
    private static int select(int[] arr, int begin, int end, int k) {
        if (begin == end) {
            return arr[begin];
        }
        //计算逻辑分组后,取中位数组成新数组，对新数组求中位数
        int pivot = medianOfMedians(arr, begin, end);

        int[] pivotRange = partition(arr, begin, end, pivot);

        //如果k值在等于区域范围内,则直接返回第k个值
        if (k >= pivotRange[0] && k <= pivotRange[1]) {
            return arr[k];
        } else if (k < pivotRange[0]) {
            return select(arr, begin, pivotRange[0] - 1, k);
        } else {
            return select(arr, pivotRange[1] + 1, end, k);
        }
    }

    /**
     * begin ~ end范围逻辑分组,分组后求中位数
     *
     * @return
     */
    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        //数组以5个为逻辑分组,不足5个部分单独作为一个逻辑分组,最后一个逻辑分组也只有一个中位数
        int offset = num % 5 == 0 ? 0 : 1;
        //保存中位数数组
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            //对arr数组等分后的逻辑小组求中位数 并填充入mArr数组
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        //对中位数数组求中位数
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        insertSort(arr, begin, end);
        //对逻辑小组内求中位数
        int sum = end + begin;
        // (sum % 2)处理
        int mid = (sum / 2) + (sum % 2); //逻辑小组内中位下标
        return arr[mid];
    }

    /**
     * 在begin~end范围内对pivot做荷兰国旗问题
     *
     * @return 返回等于区域范围
     */
    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = -1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    private static void insertSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i < end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 9, 8, 0, 6};
        System.out.println(getMinKthByBFPRT(arr, 3));
    }
}
