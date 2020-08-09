/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter4;

/**
 * @author yan.zhang
 * @date 2020/7/18 14:39
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * 二叉树 --->  搜索二叉树（TreeMap ：key按照某种方式有序组织，组织方式就是二叉树，本质是红黑树）
 * <p>
 * 搜索二叉树：
 * 1.搜索二叉树的中序遍历一定是升序的
 * <p>
 * <p>
 * 红黑树具有某种平衡性的搜索二叉树
 * <p>
 * 平衡性：严格意义上平衡指的是，任何一个节点左子树和右子树高度差不超过1。（可以近似认为左子树和右子树规模一样，每次查找可以淘汰一半规模）
 * 延申：
 * 1）AVL树:严格平衡，任何一个子节点左子树和右子树高度差不超过1。形成树过程中有调整（旋转）逻辑，和输入顺序无关。 调整时间复杂度O(logN)
 * <p>
 * 2）红黑树：
 * 头节点，叶节点必须为黑。
 * 相邻两个节点不能都是红节点
 * <p>
 * 性质：从头节点出发，到叶节点所有子链，最长链和最短链长度差一定不超过两倍（特殊的“平衡”）
 * 目的：1.保证左子树和右子树规模相差不多 2.达到“平衡性”不需要调调整的很频繁
 * <p>
 * <p>
 * 3）SB树
 * <p>
 * <p>
 * 所有的平衡二叉树  增删改查 时间复杂度都是O(logN)
 * <p>
 * <p>
 * <p>
 * <p>
 * 搜索二叉树：对于任意头节点，左节点小于该节点，右节点大于该节点
 */
public class SortTree {

    /**
     * 如果操作行为只是根据key 查找 value 使用hashMap即可
     *
     * @param args
     */
    public static void main(String[] args) {
        //TreeMap数据结构为红黑树,所有key按有序组织，增删改查操作均为O(logN)代价
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "zhang");
        treeMap.put(2, "yan");
        treeMap.put(25, "hai");
        treeMap.put(3, "xiao");
        treeMap.put(4, "yao");

        //O(logN)
        System.out.println(treeMap.get(1));
        //O(logN)
        System.out.println(treeMap.containsKey(2));

        //返回最大值key，这颗搜索二叉树最大值,O(logN)
        //与hashMap不同点，hash表中只能遍历O(N),
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.firstKey());

        //25  如果值不存在，返回第一个比指定值大的那个值
        //在hashMap中只能遍历解决
        System.out.println(treeMap.ceilingKey(5));

        //4 如果值不存在，返回第一个比指定值小的那个值
        System.out.println(treeMap.floorKey(5));

        System.out.println("==============================");


        //TreeMap中key按照自然序排序，即遍历时key由小到大
        //TreeMap中数据的组织方式为红黑树（平衡搜索二叉树)
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(String.format("key:%s value:%s", key, value));
        }
    }
}
