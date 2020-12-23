package src.off.heap;

/**
 * @author yan.zhang
 * @date 2020/12/22 16:10
 */
public class FindKth {
    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * <p>
     * 输入 [1,3,5,2,2],5,3 输出2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 2};
        findKth(arr, 5, 3);
    }

    private static void findKth(int[] arr, int n, int K) {

    }

}
