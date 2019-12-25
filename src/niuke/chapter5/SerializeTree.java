/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/24 22:28
 */

import src.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化一颗树
 */
public class SerializeTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        String res = serializeByPre(head);
        System.out.println(res);
    }

    /**
     * 先序遍历方式序列化
     * #代表null
     * _分隔两个node
     */
    private static String serializeByPre(TreeNode head) {
        if (head == null) {
            return "#_";
        }
        String res = head.getValue() + "_";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    private static TreeNode reconstructionByPreString(String preStr) {
        //1.还原为数组
        String[] treeArray = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : treeArray) {
            queue.offer(s);
        }
        //2.还原树
        return reconstructionByPre(queue);
    }

    private static TreeNode reconstructionByPre(Queue<String> queue) {
        String value = queue.poll();
        //如果第一个为null,则
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = reconstructionByPre(queue);
        head.right = reconstructionByPre(queue);
        return head;
    }
}
