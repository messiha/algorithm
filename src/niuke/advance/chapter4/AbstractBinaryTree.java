/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter4;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/7/18 17:52
 */

/**
 * 抽象搜索二叉树
 * 插入 查找 删除
 */
public class AbstractBinaryTree {

    private TreeNode root;
    private int size;


    protected TreeNode createNode(int val, TreeNode parent, TreeNode left, TreeNode right) {
        return new TreeNode(val, parent, left, right);
    }

    /**
     * 查找
     */
    protected TreeNode search(int element) {
        TreeNode node = root;
        while (node != null && node.value != null && node.value != element) {
            if (element < node.getValue()) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    /**
     * 插入
     */
    protected TreeNode insert(int element) {
        if (null == root) {
            root = createNode(element, null, null, null);
            size++;
            return root;
        }
        //插入节点的父节点;
        TreeNode insertParentNode = null;
        TreeNode searchTmpNode = root;

        while (searchTmpNode != null && searchTmpNode.value != null) {

            insertParentNode = searchTmpNode;

            if (element < searchTmpNode.value) {
                searchTmpNode = searchTmpNode.left;
            } else {
                searchTmpNode = searchTmpNode.right;
            }
        }

        TreeNode newNode = createNode(element, insertParentNode, null, null);

        if (insertParentNode.value < element) {
            insertParentNode.right = newNode;
        } else {
            insertParentNode.left = newNode;
        }
        size++;
        return newNode;
    }

    /**
     * 删除
     */
    protected TreeNode delete(int element) {

        TreeNode deleteNode = search(element);

        if (deleteNode != null) {
            return delete(deleteNode);
        } else {
            return null;
        }

    }

    private TreeNode delete(TreeNode deleteNode) {
        return null;
    }
}
