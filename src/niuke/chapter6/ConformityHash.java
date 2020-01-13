/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter6;

/**
 * @author yan.zhang
 * @date 2020/1/12 12:20
 */

/**
 * 一致性哈希问题
 * 经典模型的负载均衡，算hashCode，对机器数量取模，机器扩容场景下，必须要将数据重新计算hash
 * 一致性哈希解决方案：
 */
public class ConformityHash {
    public static void main(String[] args) {
        String s = "szsssssggggggggggggggggggfdfdsss";
        System.out.println(s.hashCode());
    }

}
