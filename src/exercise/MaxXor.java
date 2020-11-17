/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

/**
 * @author yan.zhang
 * @date 2020/11/15 16:37
 */
public class MaxXor {

    private static int baseSolution(int[] arr) {
        int res = Integer.MIN_VALUE;

        //以i位置结尾
        for (int i = 0; i < arr.length; i++) {

            for (int start = 0; start < arr.length; start++) {
                int cur = 0;
                for (int end = start; end <= i; end++) {
                    cur = cur ^ arr[end];
                }
                res = Math.max(res, cur);
            }

        }
        return res;
    }


    /**
     * 条件：
     * E1 ^ E2  = E3
     * <p>
     * 结论：
     * E1 ^ E3 = E2
     * E2 ^ E3 = E1
     * <p>
     * 所以
     * 0~i = [0~start-1] ^ [start~i]
     * <p>
     * [start~i] = [0~i] ^ [0~start-1]
     */
    private static int solutionByDp(int[] arr) {
        int max = Integer.MIN_VALUE;

        int[] dp = new int[arr.length];

        int eor = 0;

        //以i结尾的异或和
        for (int i = 0; i < arr.length; i++) {
            //0...i
            eor ^= arr[i];
            max = Math.max(max, eor);

            //以start开始 i位置结尾的异或和
            for (int start = 1; start <= i; start++) {

                //start~i的异或和 为 0~i ^ 0~start-1
                int cur = eor ^ dp[start - 1];
                max = Math.max(max, cur);
            }

            dp[i] = eor;
        }

        return max;

    }

    /**
     * 假设一个黑盒结构
     * 功能:
     * 记录 0~0，0~1，0~2 ... 0~i-1的异或和
     * 全局变量xor代表0~i的异或和
     * <p>
     * 假设返回0~2 ^ xor 最大，则代表3~i的子数组为最大异或和
     */
    public static int solutionByTrie(int[] arr) {
        System.out.println();
        return 0;
    }


    private static class Node {
        private int[] next;
    }

    private static class Trie {
        private Node head;

        public Trie() {
            this.head = new Node();
        }

        public void add(int num) {

        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 9, 6, 15};

        System.out.println(baseSolution(arr));
        System.out.println(solutionByDp(arr));


        int i = -1;
        System.out.println(Integer.toBinaryString(-1));

    }
}
