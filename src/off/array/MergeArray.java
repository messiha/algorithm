package src.off.array;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/12/23 16:41
 */
public class MergeArray {
    /**
     * 给出两个有序的整数数组A和B，请将数组 B合并到数组A中，变成一个有序的数组
     * 注意：
     * 可以假设 A数组有足够的空间存放 B数组的元素， A和B中初始的元素数目分别为m和n
     */
    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 1;
        A[1] = 4;
        A[2] = 8;
        int[] B = new int[]{2, 7, 10};
        merge(A, 3, B, 3);
//      merge2(A, 3, B, 3);

        System.out.println(Arrays.toString(A));
    }

    public static void merge2(int A[], int m, int B[], int n) {
        int[] help = new int[m + n];
        int hi = 0;
        int ai = 0;
        int bi = 0;

        while (ai < m && bi < n) {
            help[hi++] = A[ai] < B[bi] ? A[ai++] : B[bi++];
        }
        while (ai < m) {
            help[hi++] = A[ai++];
        }
        while (bi < n) {
            help[hi++] = B[bi++];
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = help[i];
        }
    }

    /**
     * 双指针，从尾部遍历，不需要额外空间
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int A[], int m, int B[], int n) {
        int ai = m - 1;
        int bi = n - 1;
        int p = m + n - 1;

        while (ai >= 0 && bi >= 0) {
            A[p--] = A[ai] < B[bi] ? B[bi--] : A[ai--];
        }
        //若B没有走完
        while (bi >= 0) {
            A[p--] = B[bi--];
        }

    }

}
