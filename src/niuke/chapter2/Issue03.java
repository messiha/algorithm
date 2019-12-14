/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter2;

/**
 * @author yan.zhang
 * @date 2019/10/5 17:23
 */

/**
 * 发射器每次发射一个数，当发射器停止时，求这组数的中位数
 *
 * 思路：假设数组长度为N/2,尽量使得较小N/2数在大根堆，较大N/2的数在小根堆（需要 平衡堆数量操作，弹出堆顶操作）
 *
 * 堆结构优势：每次向堆中加入一个数，调整堆代价为O(logN)，即树高度
 */
public class Issue03 {

}
