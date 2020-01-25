/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2019/11/19 15:43
 */
public class Demo {
    public static void main(String[] args) throws IOException {

    }

    private static Node copyRandomList(Node head) {
        if (null == head || head.next == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (null != cur) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (null != cur) {
            Node nodeCp = map.get(cur);
            nodeCp.next = map.get(cur.next);
            nodeCp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 含有随机指针链表结构
     */
    private static class Node {
        public int val;
        public Node next;
        public Node random;

        private Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}

