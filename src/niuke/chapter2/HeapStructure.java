/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter2;

/**
 * @author yan.zhang
 * @date 2019/10/5 10:39
 */

import java.util.Arrays;

/**
 * 完全二叉树：若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * 满二叉树： 除最后一层无任何子节点外，每一层上的所有结点都有两个子结点的二叉树。
 * <p>
 * 堆结构：堆是一个完全二叉树
 * 堆结构分为 大根堆和小根堆
 * 大根堆：完全二叉树中任何一颗子树的最大值都是头部
 * 小根堆：完全二叉树中任何一颗子树的最小值都是头部
 * <p>
 * 堆排序准备：将数组形成大根堆
 * <p>
 * 将数组arr抽象为完全二叉树
 * 已知某一head下标为i 则左child在数组中下标：2*i+1 右child在数组中下标：2*i+2
 * 已知某一child下标为i 则head在数组中下标：(i-1)/2
 * <p>
 * 堆顶弹出操作：1）heap中最后一个数替换堆顶  2）heapSize - 1 3）经历一次heapify("下沉"操作)
 */
public class HeapStructure {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //依次加入arr[i],在数组0~i范围内形成大根堆 形成大根堆的过程时间复杂度只和树的高度有关
            //依次加入..i-1,i,i+1,对于数组长度为N的数组形成大根堆，时间复杂度为O(N)
            heapInsert(arr, i);
        }
    }

    /**
     * heapInsert 加入一个新节点并且向上调整的过程
     */
    private static void heapInsert(int[] arr, int index) {
        //arr[(index - 1) / 2] 父节点值
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    /**
     * heapify函数  数组中有某一值发生变化(变小)，重新调整为大根堆的过程  （向下调整过程）
     *
     * @param index    数组中变化值下标(即head)
     * @param heapSize 代表此时此刻堆大小，用于越界判断
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int leftChildIndex = 2 * index + 1;
        while (leftChildIndex < heapSize) {
            //返回左child和右child较大一方的Index坐标
            int largest = leftChildIndex + 1 < heapSize && arr[leftChildIndex] < arr[leftChildIndex + 1]
                    ? leftChildIndex + 1
                    : leftChildIndex;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            leftChildIndex = 2 * index + 1;
        }
    }


    /**
     * 交换位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
