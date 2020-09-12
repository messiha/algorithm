package src.niuke.advance.chapter6;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author yan.zhang
 * @date 2020/8/30 19:52
 */

public class LFU {
    /**
     * 最近不频繁使用，set()和get()都是O(1)的操作
     * 可以理解为：set()和get()都会让"访问次数 加 1 " 当达到内存最大值，淘汰访问次数最少的记录
     * 备注：若访问次数相同，则保留最近一次访问的key
     * <p>
     * LFU算法是根据在一段时间里数据项被使用的次数选择出最少使用的数据项，即根据使用次数的差异来决定。
     * 而LRU是根据使用时间的差异来决定的。
     */
    public static void main(String[] args) {

    }


    private static class Node {
        private int key;
        private int value;
        private int times;
        private Node up;
        private Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value &&

                    times == node.times &&
                    Objects.equals(up, node.up) &&
                    Objects.equals(down, node.down);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value, times, up, down);
        }
    }

    private static class LFUCache {
        private int capture;
        private int size;
        //key - node 对于get，set操作传入的key，判断key对应的value是否已经在LFU中存在
        private HashMap<Integer, Node> records;
        //Node对应的NodeList，对于任意一个Node可以找到属于的NodeList
        private HashMap<Node, NodeList> heads;
        private NodeList headList;

        public LFUCache(int capture) {
            this.capture = capture;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            this.headList = null;
        }

        public void set(int key, int value) {
            //检查"记录表"中是否包含该记录
            if (records.containsKey(key)) {
                Node node = records.get(key);
                //更新
                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node);
                //node移动到下一个nodeList
                move(node, curNodeList);
            } else {
                //容量已经达到上限，触发清除机制,清理最近使用最少的记录
                if (size == capture) {
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    modifyNodeList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    this.size--;
                }

                Node node = new Node(key, value, 1);
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    //headList不为null，判断该headList下的次数是否为1
                    if (headList.head.times == node.times) {
                        headList.addNodeFormHead(node);
                    } else {
                        NodeList newNodeList = new NodeList(node);
                        newNodeList.next = headList;
                        headList.last = newNodeList;
                        headList = newNodeList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }

        }


        public int get(int key) {
            if (!records.containsKey(key)) {
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList nodeList = heads.get(node);
            move(node, nodeList);
            return node.value;
        }

        /**
         * 如果headList指向的NodeList没有任何node，则删除该headList，且headList指针移动到下一个NodeList
         *
         * @param nodeList
         */
        private boolean modifyNodeList(NodeList nodeList) {
            if (headList.isEmpty()) {
                //删除
                if (headList == nodeList) {
                    headList = nodeList.next;
                    if (headList != null) {
                        headList.last = null;
                    }
                } else {
                    //nodeList不是"大链表"头结点，nodeList删除，nodeList前后节点连接
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null) {
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        /**
         * 将位于oldNodeList上的node移动到新的nodeList上
         *
         * @param node        需要移动的node
         * @param oldNodeList 该node对应的NodeList
         */
        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);

            //如果oldNodeList删除node节点，可能oldNodeList上无node，则该oldNodeList需要删除
            NodeList preNodeList = modifyNodeList(oldNodeList) ? oldNodeList.last : oldNodeList;

            NodeList nextNodeList = oldNodeList.next;

            if (null == nextNodeList) {
                NodeList newNodeList = new NodeList(node);
                if (preNodeList != null) {
                    preNodeList.next = newNodeList;
                }
                newNodeList.last = preNodeList;

                if (headList == null) {
                    headList = newNodeList;
                }
                heads.put(node, newNodeList);
            } else {
                if (nextNodeList.head.times == node.times) {
                    nextNodeList.addNodeFormHead(node);
                    heads.put(node, nextNodeList);
                } else {
                    NodeList newNodeList = new NodeList(node);
                    if (preNodeList != null) {
                        preNodeList.next = nextNodeList;
                    }
                    newNodeList.last = preNodeList;
                    newNodeList.next = nextNodeList;
                    newNodeList.last = newNodeList;
                    if (headList == nextNodeList) {
                        headList = newNodeList;
                    }
                    heads.put(node, newNodeList);
                }
            }
        }

        /**
         * Node和Node之间是双向链表关系
         * NodeList和NodeList之间也是双向链表关系
         */
        private static class NodeList {
            private Node head;
            private Node tail;
            private NodeList last;
            private NodeList next;

            public NodeList(Node node) {
                this.head = node;
                this.tail = node;
            }

            /**
             * 新节点加入到头部
             * 删除时则从尾部开始删除
             *
             * @param newHead
             */
            public void addNodeFormHead(Node newHead) {
                newHead.down = head;
                head.up = newHead;
                this.head = newHead;
            }

            public boolean isEmpty() {
                return head == null;
            }

            public void deleteNode(Node node) {

                if (head == tail) {
                    this.head = null;
                    this.tail = null;
                } else {
                    if (node == head) {
                        this.head = head.down;
                        this.head.up = null;
                    } else if (node == tail) {
                        this.tail = tail.up;
                        this.tail.down = null;
                    } else {
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;

            }
        }


    }

}
