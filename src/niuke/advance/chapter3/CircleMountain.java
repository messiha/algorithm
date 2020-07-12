package src.niuke.advance.chapter3;

/**
 * @author yan
 * @date 2020/7/1111:47
 */

/**
 * 环形山问题：
 * 给定数组[1,2,4,5,3]
 * 5
 * / \
 * 3   4
 * \    \
 * \   2
 * \  /
 * 1
 * 1)相邻可见  1可见 2,3
 * 2)不相邻的两座山A,B A和B路径中不存在某个值C 大于A，B中较小的，认为可见。eg：1和4  较小为1，存在3，5大于1，故不可见。
 * 3-5-4，较小值为3，存在5，不可见。3-1-2-4 路径可见。
 * <p>
 * 给定这个数据，求能相见的山峰有多少对。
 */
public class CircleMountain {

    public static void main(String[] args) {

    }
}
