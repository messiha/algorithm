package src.cmc;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yan.zhang
 * @date 2023/8/9 11:58
 */
public class DailyTemperature {
    public static int[] solution(int[] temperatures) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> temperatures[o1] - temperatures[o2]);
        int[] res = new int[temperatures.length];
        queue.offer(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peek()]) {
                Integer index = queue.poll();
                res[index] = i - index;
            }
            queue.offer(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution(temperatures)));
    }
}
