/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter6;

/**
 * @author yan.zhang
 * @date 2020/1/10 22:59
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希函数特性：
 * 1.输入域无穷大
 * 2.输出域是一个固定区间
 * 3.输入一样，输出一定一样
 * 4.当输入(无穷大域)不一样，也有可能得到输出(固定域)一致，成为哈希碰撞
 * 5.哈希函数离散性，（在输出域上均匀分布）
 * 6.推论:输出域上均匀分布，输出域对m取模，则在0~m-1上也均匀分布，ag：0~98上均匀分布，对3取模，则在0，1，2上均匀分布
 * <p>
 * 设计RandomPool结构，在该结构中有如下三个功能:
 * insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom():等概率随机返回结构中的任何一个key
 * 要求:insert，delete和getRandom方法的时间复杂度都是O(1)
 * 思路：严格等概率，一个hash表不能完成。当样本量很小，有空置的桶，当样本量很大，每个桶上链表长度不是严格意义上的一致
 */
public class RandomPool<K> {

    private final Map<K, Integer> keyIndexMap = new HashMap<>();
    private final Map<Integer, K> IndexKeyMap = new HashMap<>();
    private int size;

    public static void main(String[] args) {

    }

    private K getRandom() {
        if (size == 0) return null;
        int index = (int) (Math.random() * size);
        return IndexKeyMap.get(index);
    }

    /**
     * 删除产生空bucket,用最后一个bucket填补这个空bucket，size--,保证在[0,size]区间连续
     */
    private void delete(K key) {
        if (keyIndexMap.containsKey(key)) {
            Integer deleteIndex = keyIndexMap.get(key);
            int lastIndex = --size;
            K lastKey = IndexKeyMap.get(lastIndex);
            keyIndexMap.put(lastKey, lastIndex);//
            IndexKeyMap.put(deleteIndex, lastKey);//IndexKeyMap在被删除的bucket上存在最后一个bucket的值
            keyIndexMap.remove(key);
            IndexKeyMap.remove(lastIndex);//IndexKeyMap删除掉最后一个，保证在[0,size]区间连续
        }
    }

    private void insert(K key) {
        if (!keyIndexMap.containsKey(key)) {
            keyIndexMap.put(key, size);
            IndexKeyMap.put(size, key);
            size++;
        }
    }

}
