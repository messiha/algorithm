package src.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2020/12/18 14:37
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] results = twoSum(nums, 6);
    }


    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(8);
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(key, i);
            }
        }
        return res;
    }

}
