/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter6;

/**
 * @author yan.zhang
 * @date 2020/9/19 19:35
 */

import java.util.ArrayList;

/**
 * 跳表结构：
 * 类比红黑树
 * 跳表结构的get()和set()操作都是O(logN)的复杂度
 */
public class SkipListStructure {

    public static class Node {
        public Integer value;
        /**
         * nextNodes.size() = 10 代表该node有10层
         * nextNodes[0]:第1层上该node的下一个节点
         * ag:nextNodes.size() = 5 该node有5层，下标为[0,4]
         */
        public ArrayList<Node> nextNodes;

        public Node(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    public static class SkipList {
        private Node head;
        /**
         * 骰子摇出的最大层
         */
        private int maxLevel;
        private int size;
        /**
         * 骰子摇出0,1的概率
         */
        private static final double PROBABILITY = 0.5;


        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new Node(null);
            head.nextNodes.add(null);
        }

        public void add(Integer newValue) {
           /* if (!contains(newValue)) {

            }*/
            int level = 0;
            while (Math.random() < PROBABILITY) {
                //Math.random()产生的浮点数小于PROBABILITY,level + 1，大于0.5停止
                level++;
            }
            while (level > maxLevel) {
                head.nextNodes.add(null);
                maxLevel++;
            }
            Node newNode = new Node(newValue);
            Node current = head;
            int levelAll = maxLevel;
            do {
                current = findNext(newValue, current, levelAll);
                if (level >= levelAll) {
                    newNode.nextNodes.add(0, current.nextNodes.get(level));
                    current.nextNodes.set(level, newNode);
                    level--;
                }

            } while (levelAll-- > 0);

        }

        private Node findNext(Integer e, Node cur, int level) {
            //cur.nextNodes.get(level):表示cur节点的list中，第level层的值，这个值是第level层的下一个节点
            Node next = cur.nextNodes.get(level);
            while (next != null) {
                Integer value = next.value;
                if (lessThan(e, value)) {
                    break;
                }
                cur = next;
                next = cur.nextNodes.get(level);
            }
            return cur;
        }

        private boolean lessThan(Integer e, Integer value) {
            return e < value;
        }
    }

}
