package src.niuke.advance.chapter3;

/**
 * @author yan
 * @date 2020/7/512:45
 */

import java.util.Stack;

/**
 * 求最大子矩阵大小
 * 给定一个整形矩阵map，其中的值只有0，1两种，求矩阵中全是1的所有矩阵区域中，最大矩阵区域为1的数量
 * <p>
 * eg：1 1 1 0
 * 其中最大矩阵区域有3个1，所以返回3
 * <p>
 * eg:
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中最大的矩阵区域有6个1，返回6
 */
public class MaxSubMatrix {

    /**
     * 类比直方图问题：
     * 将一个数据抽象为一个直方图，数组中每个位置的值，代表直方图中柱状图的高度。
     * <p>
     * 1 0 1 1  >  [1,0,1,1] 带入直方图问题，求第一行中 子矩阵最大数量
     * 1 1 1 1  >  [2,1,2,2] 第二行将第一行"合并" 带入直方图问题
     * 1 1 1 0  >  [3,2,3,0] ....第三行最后一个值为0,不能和其他位置"合并"形成子矩阵，故组合上方的 1,1 得到 0
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 5, 6};
        System.out.println(maxRecFromBottom(arr));

    }

    /**
     * 用数组标识直方图，求直方图中最大正方形面积，直方图问题求解函数
     *
     * @param arr
     * @return
     */
    private static int maxRecFromBottom(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                Integer j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                //不满足单调栈 栈底到栈顶由小到大的顺序，当不满足该条件，意味着：当前栈顶的元素移动范围确定。
                //eg:[5,6,3,7,2] 当3入栈，条件不满足，（此时单调栈可快速得到6左侧最近比6小的数5，6右侧最近比6小的数3），栈中元素弹出计算最大面积
                int curArea = (i - k - 1) * arr[j];

                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }

        //数组遍历完成，单调栈中仍有元素，单独处理
        while (!stack.isEmpty()) {
            Integer j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (arr.length - k - 1) * arr[j];
            maxArea = Math.max(curArea, maxArea);
        }

        return maxArea;
    }
}
