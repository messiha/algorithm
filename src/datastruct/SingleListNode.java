package src.datastruct;

public class SingleListNode {
    public int val;
    public SingleListNode next = null;

    public SingleListNode(int val) {
        this.val = val;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

}
