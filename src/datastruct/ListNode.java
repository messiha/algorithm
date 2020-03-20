package src.datastruct;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
