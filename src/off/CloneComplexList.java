/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/22 18:14
 */

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneComplexList {


    /*public static RandomListNode clone(RandomListNode pHead) {
        if (null == pHead || pHead.next == null) {
            return pHead;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap(10);
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = pHead;

        while (cur != null) {
            RandomListNode cpNode = map.get(cur);
            cpNode.next = map.get(cur.next);
            cpNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }*/

    public static RandomListNode clone(RandomListNode pHead) {
        if (null == pHead) {
            return pHead;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode cpNode = new RandomListNode(cur.label);
            RandomListNode curNext = cur.next;
            cur.next = cpNode;
            cur.next.next = curNext;
            cur = curNext;
        }
        cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        cur = pHead;
        RandomListNode res = cur.next;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            RandomListNode copy = cur.next;
            cur.next = next;
            copy.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
