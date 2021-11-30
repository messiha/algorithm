package src.xmly;

import java.util.PriorityQueue;

/**
 * @Author yan.zhang
 * @Date 2021/11/30 16:41
 * @Version 1.0
 */
public class KthLargest {
    /**
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 8, 3, 2, 5, 10, 9, 4};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(11));
        System.out.println(kthLargest.add(8));
        System.out.println(kthLargest.add(15));
    }

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        //初始化大小为K的小根堆,堆顶即为第K大元素
        if (queue.size() < k) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }


}
