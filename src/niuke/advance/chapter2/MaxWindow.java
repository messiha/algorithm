/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter2;

/**
 * @author yan.zhang
 * @date 2020/6/21 10:43
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大数组：
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左侧滑到最右侧，窗口每次向右滑一个位置，例如
 * 数组为[4,3,5,4,3,3,6,7],当窗口大小为3时
 * 【4 3 5】4 3 3 6 7  窗口最大值为5
 * 4【3 5 4】 3 3 6 7  窗口最大值为5
 * 4 3 【5 4 3】 3 6 7  窗口最大值为5
 * 4 3 5 【4 3 3】 6 7  窗口最大值为4
 * 4 3 5  4 【3 3 6】 7  窗口最大值为6
 * 4 3 5  4 3 【3 6 7】  窗口最大值为7
 * 如果数组长度为n 窗口大小为w 则一共产生n-w+1个窗口最大值
 * 请实现一个函数
 * 输入：整形数组arr，窗口大小为w
 * 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
 *
 * 以上述为例：结果返回[5,5,5,4,6,7]
 */
public class MaxWindow {

    /**
     * L,R分别为窗口左边界和右边界，L，R只能右移不能左移
     * 双端队列结构 （需保证双端队列 从左到右 是 由大到小 的接口，不能相等）
     * 入队列从尾入
     */
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};

        System.out.println(Arrays.toString(getMaxWindow(arr, 3)));
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> list = new LinkedList<>();

        int[] res = new int[arr.length - w + 1];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            //双端链表不为空 并且 双端链表尾节点小于当前值,将尾节点弹出直到 链表为空 或 尾节点大于当前值
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            //尾部入
            list.addLast(i);

            //检查队头是否过期，如果过期弹出
            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }
            //收集当前队列最大值
            if (i + 1 >= w) {
                res[index++] = arr[list.peekFirst()];
            }

        }
        return res;
    }
}
