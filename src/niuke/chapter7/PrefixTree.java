/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7;

/**
 * @author yan.zhang
 * @date 2020/1/24 22:36
 */

/**
 * 前缀树
 * 检查某节点next指向的是否为null判断是否存在某条'路径'是否存在
 */
public class PrefixTree {
    public static class TrieNode {
        private int path;//有多少节点到达过该Node
        private int end;//有多少字符串以该Node结尾
        private TrieNode[] next;//a~z 26个字母，标识有26条路

        public TrieNode() {
            path = 0;
            end = 0;
            next = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * 前缀树加入一个字符串
         */
        public void insert(String word) {
            if (null == word) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';// 'b' 则 index = 1,'a' 则 index = 0
                if (node.next[index] == null) { //根据next数组中node.next[index]判断是否存在该字符
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            //检查word是否在前缀树存在
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.next[index].path == 0) { //路径中的某一节点path = 0 后续的node直接丢弃
                        node.next[index] = null;
                        return;
                    }
                    //移动node
                    node = node.next[index];
                }
                node.end--;
            }
        }

        /**
         * 检查某以word 插入次数
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (null == word) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                //指向下一个node
                node = node.next[index];
            }
            return node.end;
        }

        /**
         * 检查以pre前缀开头的字符串数量
         *
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.path;
        }

    }

    public static void main(String[] args) {

    }
}
