package src.niuke.advance.chapter4;
/**
 * 大楼轮廓问题
 * 给定一个N行3列的二维数组，每一行表示有一座大楼，
 * 一共有N座大楼
 */

import java.util.*;

/**
 * @author yan.zhang
 * @date 2020/8/6 23:40
 */
public class OutLint {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 3}, {2, 4, 4}, {5, 6, 1}};
        System.out.println(buildingOutLine(arr).toString());
    }

    private static List<List<Integer>> buildingOutLine(int[][] buildings) {
        //预处理
        Node[] nodes = new Node[buildings.length * 2];

        //每个"楼"预处理成两份数据
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }

        //按照位置排序
        Arrays.sort(nodes, new NodeComparator());
        //key:当前高度 value：当前高度出现次数
        TreeMap<Integer, Integer> tpMap = new TreeMap<>();

        //key：当前位置pos，value：当前位置最大高度。  记录遍历到每个位置时，在这个位置的"大楼"高度最大值。
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();

        for (int i = 0; i < nodes.length; i++) {
            //是否为 "上"
            if (nodes[i].isUp) {
                //高度是否第一次出现
                if (!tpMap.containsKey(nodes[i].h)) {
                    tpMap.put(nodes[i].h, 1);
                } else {
                    tpMap.put(nodes[i].h, tpMap.get(nodes[i].h) + 1);
                }
            } else {
                if (tpMap.containsKey(nodes[i].h)) {
                    if (tpMap.get(nodes[i].h) == 1) {
                        tpMap.remove(nodes[i].h);
                    } else {
                        tpMap.put(nodes[i].h, tpMap.get(nodes[i].h) - 1);
                    }
                }
            }

            //记录每个位置，当前最大高度
            if (tpMap.isEmpty()) {
                //hTreeMap为空，第一次循环，将最大高度为0存入pmMap
                pmMap.put(nodes[i].pos, 0);
            } else {
                pmMap.put(nodes[i].pos, tpMap.lastKey());
            }
        }
        //tpMap动态变化，遍历完成后tmMap为空
        //根据pmMap重新构建轮廓线，原则：每个点位最大高度发生变化时产生轮廓线
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            Integer curPos = entry.getKey();
            Integer curMaxHeight = entry.getValue();

            if (height != curMaxHeight) {
                //最大高度变化，轮廓线产生
                if (height != 0) {
                    List<Integer> record = new ArrayList<>();
                    record.add(start);
                    record.add(curPos);
                    record.add(height);
                    res.add(record);
                }
                //之前位置高度 == 0 ，说明轮廓线开始生成
                start = curPos;
                height = curMaxHeight;
            }

        }
        return res;
    }

    /**
     * Node封装大楼轮廓信息
     */
    private static class Node {
        private boolean isUp;
        private int pos;
        private int h;

        public Node(boolean isUp, int pos, int h) {
            this.isUp = isUp;
            this.pos = pos;
            this.h = h;
        }
    }

    /**
     * 位置小的排在前，位置大的靠后
     */
    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.pos != o2.pos) {
                return o1.pos - o2.pos;
            }
            //如果pos位置一样，出现重合，"上"排在前
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }
}
