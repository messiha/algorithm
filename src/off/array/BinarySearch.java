package src.off.array;

/**
 * @author yan.zhang
 * @date 2020/12/21 12:13
 */
public class BinarySearch {
    /**
     * 请实现有重复数字的有序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     * 输出位置从1开始计算
     * 5,4,[1,2,4,4,5]
     * 返回值3
     */

    public static void main(String[] args) {
        int res = upper_bound_(5, 2, new int[]{1, 2, 4, 4, 5});
        int res2 = upper_bound_2(10, 1, new int[]{2, 3, 4, 4, 4, 7, 7, 8, 10, 10});
        System.out.println(res2);
//        System.out.println(res);
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {
        return solution(n, v, a, 0, a.length - 1);
    }


    //不通过，要求返回第一个大于等于的位置，对于数组中多个相等不能返回第一个大于等于
    private static int solution(int n, int v, int[] a, int l, int r) {
        int mid = l + ((r - l) >> 1);
        while (l <= r) {
            if (a[mid] < v) {
                return solution(n, v, a, mid + 1, r);
            } else if (a[mid] > v) {
                return solution(n, v, a, l, mid - 1);
            } else {
                return mid + 1;
            }
        }
        return n + 1;
    }


    private static int upper_bound_2(int n, int v, int[] a) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] < v) {
                l = mid + 1;
            } else if (a[mid] > v) {
                if (mid == 0 || a[mid - 1] < v) {
                    //有序 判断前一个数是否小于，如果小于，则是第一个大于等于的数，直接返回
                    return mid + 1;
                }
                //否则，不是第一个大于等于的数字，继续查找
                r = mid - 1;
            } else {
                // == 情况,同上
                if (mid == 0 || a[mid - 1] != v) {
                    return mid + 1;
                } else {
                    r = mid - 1;
                }

            }
        }
        return n + 1;
    }
}
