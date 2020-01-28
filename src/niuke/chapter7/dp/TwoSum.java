/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/28 14:02
 */

/**
 * 数组arr，和一个整数aim，可以任意选择arr中的数字，能不能累加得到aim，返回true和false
 * 假设arr和aim全部为正数
 * 1.暴力穷举
 * 2.确定可变参数，i,sum
 * 3.确定可变参数变化范围
 * 4.起始位置
 * 5.baseCase
 * 5.针对一个普遍位置是依赖哪些位置
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 11;
        System.out.println(process(arr, 0, 0, target));
    }

    /**
     * @param arr
     * @param i      arr中位置
     * @param sum    累加和
     * @param target
     * @return
     */
    private static boolean process(int[] arr, int i, int sum, int target) {
        //baseCase:基本情况，基本情况不需要依赖任何条件，直接可以做出判断
        //i到达数组最后一个位置，之后，到达决策树最后一层
        if (i == arr.length) {
            return sum == target;
        }
        //对于每一个位置都有两个决策 保留||不保留 类比字符串子序列
        //不保留:sum
        //保留:sum+arr[i]
        //在决策树最后一层(叶节点上判断),决策树最后一层暴力枚举出所有情况
        return process(arr, i + 1, sum, target) || process(arr, i + 1, arr[i] + sum, target);
    }
}
