/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter6;

/**
 * @author yan.zhang
 * @date 2020/1/11 20:26
 */

/**
 * 布隆布隆过滤器
 * 本质是查询某数据是否在一个集合中
 * 存在失误率
 */
public class BlondFilter {
    public static void main(String[] args) {
        blondFilter();
    }

    private static void blondFilter() {
        /*long[] arr = new long[1000]; //1000*64=64000   64000bit大小

        long target = 30000;

        int longArrIndex = (int) (target / 64); //arr数组桶位置


        int bitIndex = (int) (target % 64); //对应桶内的bit位置

        System.out.println(arr[longArrIndex]);

        arr[longArrIndex] = (arr[longArrIndex] | (1 << bitIndex));

        System.out.println(arr[longArrIndex]);*/
    }
}
