/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

/**
 * @author yan.zhang
 * @date 2020/11/15 16:11
 */
public class PrefixTree {

    private static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] next;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.next = new TrieNode[26];
        }
    }


    private static class Trie {
        private TrieNode head;

        public Trie() {
            this.head = new TrieNode();
        }

        public void insert(String str) {
            if (str == null) {
                return;
            }

            TrieNode node = head;

            char[] chars = str.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';

                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.path++;
            }

            node.end++;


        }
    }
}
