/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter6;

/**
 * @author yan.zhang
 * @date 2020/1/12 18:48
 */

import java.util.HashMap;
import java.util.List;

/**
 * 并查集：
 * 使用前必须有所有样本
 * 1):快速查找两个元素是否在同一个集合中
 * 2):两个元素各自所在的集合合并
 */
public class UnionFind {
    public static class Node {
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap; //key:child value:father  模拟单项链表
        public HashMap<Node, Integer> sizeMap;//某节点所在的集合共有多少节点

        public UnionFindSet(List<Node> nodes) {
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 查找任意一个节点的代表节点
         * 优化操作：在查询过程中将其路径上的父节点全部挂在代表节点上
         */
        private Node findRepresentNode(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findRepresentNode(father);
            }
            fatherMap.put(node, father); //压缩成一颗多叉树
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findRepresentNode(a) == findRepresentNode(b);
        }

        /**
         * 合并操作
         */
        public void union(Node a, Node b) {
            if (null == a || null == b) {
                return;
            }
            Node headA = findRepresentNode(a);
            Node headB = findRepresentNode(b);

            if (headA != headB) {
                Integer setSizeA = sizeMap.get(headA);
                Integer setSizeB = sizeMap.get(headB);
                if (setSizeA <= setSizeB) {
                    fatherMap.put(headA, headB);
                    sizeMap.put(headB, setSizeA + setSizeB);
                } else {
                    fatherMap.put(headB, headA);
                    sizeMap.put(headA, setSizeA + setSizeB);
                }
            }
        }
    }
}
