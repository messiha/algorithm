/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.datastruct;

/**
 * @author yan.zhang
 * @date 2019/10/17 23:25
 */
public class DoubleListNode {
    public int val;
    public DoubleListNode pre = null;
    public DoubleListNode next = null;

    public DoubleListNode getNext() {
        return next;
    }

    public DoubleListNode(int val) {
        this.val = val;
    }

    public void setNext(DoubleListNode next) {
        this.next = next;
    }

    public DoubleListNode getPre() {
        return pre;
    }

    public void setPre(DoubleListNode pre) {
        this.pre = pre;
    }
}
