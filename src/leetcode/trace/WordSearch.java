package src.leetcode.trace;

/**
 * @Author yan.zhang
 * @Date 2022/3/8 10:20
 * @Version 1.0
 */
public class WordSearch {
    /**
     * https://leetcode-cn.com/problems/word-search/
     * 单词搜索
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }


    /**
     * 假定搜索顺序
     * 上 右 下 左
     *
     * @param board
     * @param word
     * @return
     */
    private static int[][] DIRECTION = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        if (row == 0) return false;
        boolean[][] used = new boolean[row][column];
        char[] charArray = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(board, used, i, j, 0, word.length(), charArray)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * @param board
     * @param used
     * @param x
     * @param y
     * @param begin
     * @param len   word的长度
     * @return
     */
    private static boolean dfs(char[][] board, boolean[][] used, int x, int y, int begin, int len, char[] charArray) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }

        if (board[x][y] == charArray[begin]) {
            used[x][y] = true;
            //尝试搜索
            for (int[] d : DIRECTION) {
                int newX = x + d[0];
                int newY = y + d[1];
                //剪枝
                if (isInArea(newX, newY, board) && !used[newX][newY]) {
                    if (dfs(board, used, newX, newY, begin + 1, len, charArray)) {
                        return true;
                    }
                }
            }
            used[x][y] = false;
        }
        return false;
    }

    private static boolean isInArea(int newX, int newY, char[][] board) {
        return newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length;
    }
}
