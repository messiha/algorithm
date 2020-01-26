/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7;

/**
 * @author yan.zhang
 * @date 2020/1/26 15:10
 */

import java.util.PriorityQueue;

/**
 * 一块金条分割两半，需要花费和长度数值一样的铜板，比如长度为20的金条，不管切分成长度多大的两半，都需要花费20铜板。
 * 一群人想整分金条，怎么分最省铜板
 * ag：给定数组{10,20,30}，代表三个人，预期金条切分成10，20，30长度，如果先把60长度的金条切分成10和50，花费60，再把
 * 50长度的金条切分成20，30，一共花费110铜板
 * 但是如果把程度60的金条切分成30，30花费60，再把30长度的金条切分成10，20一共花费90铜板。
 * 输入一个数组，返回分割最小代价
 * 哈夫曼编码问题：总代价，根据子代价的某种算法（累加/累乘）
 */
public class GoldPartition {
    /**
     * 思路：
     * 小根堆，大根堆
     * 堆适合用来解决贪心问题，从样本中选择最优数据
     */
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pq.size() > 1) {
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(lessMoney(arr));
    }
}
