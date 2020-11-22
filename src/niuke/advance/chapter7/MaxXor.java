/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter7;

/**
 * @author yan.zhang
 * @date 2020/11/22 13:08
 */
public class MaxXor {
    public static void main(String[] args) {


        int[] arr = new int[]{2, 3, 4, 7, 9, 6, 15};
        System.out.println(getMaxByDp(arr));

        System.out.println((solutionByTrie(arr)));
    }

    private static int getMaxByDp(int[] arr) {
        int max = Integer.MIN_VALUE;

        int[] dp = new int[arr.length];

        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];

            max = Math.max(eor, max);

            for (int start = 1; start <= i; start++) {
                int curEor = eor ^ dp[start - 1];
                max = Math.max(curEor, max);
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
        if (null == arr || arr.length == 0) {
            return 0;
        }

        Trie trie = new Trie();
        trie.add(0);
        int max = Integer.MIN_VALUE;
        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, trie.maxEor(eor));
            trie.add(eor);
        }

        return max;
    }


    private static class Node {
        private Node[] next = new Node[2];
    }

    private static class Trie {
        private Node head;

        public Trie() {
            this.head = new Node();
        }

        public void add(int num) {
            Node cur = head;
            //(num >> move) & 1 num 右移31位 和1与运算，得到符号位
            for (int move = 31; move >= 0; move--) {
                int path = ((num >> move) & 1);

                if (cur.next[path] == null) {
                    cur.next[path] = new Node();
                } else {
                    cur.next[path] = cur.next[path];
                }

                cur = cur.next[path];
            }
        }


        /**
         * 根据数据的 0~i的异或结果，选出最优解
         *
         * @param num 0~i的异或结果
         * @return
         */
        public int maxEor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;

                //如果是符号位，期望异或后为0，如果不是符号位，期望结果为1,期望最优路径
                int best = move == 31 ? path : (path ^ 1);

                //检查期望路径是否存在
                best = cur.next[best] != null ? best : (best ^ 1);

                res |= (best ^ path) << move;

                cur = cur.next[best];
            }
            return res;
        }

    }
}
