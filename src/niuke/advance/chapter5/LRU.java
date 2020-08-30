package src.niuke.advance.chapter5;

/**
 * @author yan.zhang
 * @date 2020/8/30 19:38
 */

import java.util.HashMap;
import java.util.Objects;

/**
 * 可变更缓存结构(LRU:Least Recently Used )最近最少使用（最经常使用的数据保留）
 * 举例：某数据在最近一段时间没有被访问到，当空间满时，最久没有访问的数据最先被淘汰。
 * <p>
 * 设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并且有两个功能：set(key,val),get()
 * 要求：
 * 1.set和get方法复杂度为O(1)
 * 2.某个set或get操作一旦发生，认为这个key的记录成为最经常使用的
 * 3.当缓存大小超过K时，移除最不经常使用的记录，即set或get最久远的
 */
public class LRU {
    /**
     * 思路：
     * 哈希表+双向链表
     * 双向链表尾部进头部出
     */

    public static void main(String[] args) {
        MyCache<String, Integer> myCache = new MyCache<>(3);
        myCache.put("A", 1);
        myCache.put("B", 2);
        myCache.put("C", 3);
        myCache.put("A", 4);
        myCache.put("D", 5);


        System.out.println(myCache.get("B"));
    }


    private static class MyCache<K, V> {
        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;


        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new UnsupportedOperationException("should be more than 0!");
            }
            this.keyNodeMap = new HashMap<>();
            this.nodeKeyMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
            this.capacity = capacity;
        }


        public V get(K key) {
            if (keyNodeMap.containsKey(key)) {
                Node<V> node = keyNodeMap.get(key);
                //get操作后 这个key的node置于双端队列尾部
                nodeList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void put(K key, V value) {
            if (keyNodeMap.containsKey(key)) {
                Node<V> node = keyNodeMap.get(key);

                node.value = value;

                nodeList.moveNodeToTail(node);
            } else {
                Node<V> newNode = new Node<>(value);
                keyNodeMap.put(key, newNode);
                nodeKeyMap.put(newNode, key);
                nodeList.addNode(newNode);

                //判断容量，是否触发"清除"动作
                if (keyNodeMap.size() == capacity + 1) {
                    removeMostUnusedCache();
                }

            }
        }

        private void removeMostUnusedCache() {

            Node<V> head = nodeList.removeHead();
            K key = nodeKeyMap.get(head);
            nodeKeyMap.remove(head);
            keyNodeMap.remove(key);
        }


    }

    /**
     * 自定义双向链表结构
     */
    private static class NodeDoubleLinkedList<V> {
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * 添加新节点，置于链表尾部
         */
        private void addNode(Node<V> newNode) {
            if (null == newNode) {
                return;
            }
            if (null == head) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }


        private void moveNodeToTail(Node<V> node) {
            if (this.tail == node) {
                return;
            }

            if (node == head) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }


            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;

        }


        /**
         * 达到最大容量，移除头部,并返回这个头部
         */
        private Node<V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<V> removed = this.head;

            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = head.next;
                this.head.last = null;
                removed.next = null;
            }
            return removed;
        }
    }


    private static class Node<V> {
        private V value;
        private Node<V> last;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return value.equals(node.value) &&
                    Objects.equals(last, node.last) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, last, next);
        }
    }

}
