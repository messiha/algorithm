/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.datastruct;

/**
 * @author Lenovo
 * @date 2019/12/15 11:34
 */
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;
    private TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public TreeNode(int value, TreeNode parent, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
