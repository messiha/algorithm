/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter6;

/**
 * @author yan.zhang
 * @date 2020/9/20 13:52
 */

/**
 * 给定一个数组，求子数组的最大异或和
 * * 一个数组的异或和为，数组中所有的数异或起来的结果
 */
public class SubArrayMaxXor {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 22};
        int res = getMaxBase(arr);
        //前缀树方式求解O(N)复杂度
        getMaxByTrie(arr);
        System.out.println(res);
    }

    private static int getMaxByTrie(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int eor = 0;

        Trie numTrie = new Trie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    /**
     * 字典树节点
     */
    public static class Node {
        //异或运算只有0和1,将0和1存储在字典树中
        private Node[] nexts = new Node[2];
    }


    public static class Trie {
        public Node head;

        public Trie() {
            this.head = new Node();
        }

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                //当前位数
                int path = ((num >> move) & 1);
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                //当前位如果是31代表是符号位，选择本身，如果不是符号位，尽量为1，则结果一定是最大
                int best = move == 31 ? path : (path ^ 1);
                best = cur.nexts[best] != null ? best : (best ^ 1);
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }

    }


    private static int getMaxBase(int[] arr) {
        int res = Integer.MIN_VALUE;

        //i代表结尾
        for (int i = 0; i < arr.length; i++) {

            for (int start = 0; start <= i; start++) {

                int curEor = 0;

                for (int k = start; k <= i; k++) {
                    curEor ^= arr[k];
                }
                res = Math.max(curEor, res);
            }
        }

        return res;
    }
}
