/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src;

import src.datastruct.TreeNode;

import java.util.Stack;

/**
 * @author Lenovo
 * @date 2019/12/21 17:25
 */
public class Practice3 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));

        preOrderRecur(head);
    }

    private static void preOrderRecur(TreeNode head) {
        if (null != head) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();

            s1.push(head);
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
                if (null != head.left) {
                    s1.push(head.left);
                    head = head.left;
                }
                if (null != head.right) {
                    s1.push(head.right);
                    head = head.right;
                }
            }

        }

    }
}
