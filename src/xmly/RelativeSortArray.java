package src.xmly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yan.zhang
 * @Date 2021/12/16 10:34
 * @Version 1.0
 */
public class RelativeSortArray {
    /**
     * 给定两个数组，arr1和arr2，
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * 输入:arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：输出：[2,2,2,1,4,3,3,9,6,7,19]
     * 备注：7，19没有在arr2中出现
     * <p>
     * 1 <= arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * arr2中的元素arr2[i]各不相同
     * arr2 中的每个元素arr2[i]都出现在arr1中
     */
    public static void main(String[] args) {
       /* int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
       */
        int[] arr1 = {26, 21, 11, 20, 50, 34, 1, 18};
        int[] arr2 = {21, 11, 26, 20};
        int[] result1 = sortByCompare(arr1, arr2);
        int[] result2 = sortByCount(arr1, arr2);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    /**
     * 思路1：基于比较方式，用哈希表记录 value - index关系
     * 思路2：基于非比较方式。
     */

    private static int[] sortByCompare(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> help = new HashMap<>(arr2.length);

        for (int i = 0; i < arr2.length; i++) {
            help.put(arr2[i], i);
        }

        List<Integer> arr1Boxed = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        return arr1Boxed.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //因为arr1和arr2长度都小于1000, 如果排序arr1中遇到中不存在arr2的值，下标设置为1001,这样不存在的值就在最后。
                Integer r1 = help.getOrDefault(o1, 1001);
                Integer r2 = help.getOrDefault(o2, 1001);

                //在哈希表存在，以哈希表中下标顺序为序,注意是下标顺序 不是值
                //1.两个值都在哈希表中，2.有一个值在哈希表中
                if (help.containsKey(o1) || help.containsKey(o2)) {
                    //r1,r2是 arr2中的index顺序
                    return r1 - r2;
                }

                //两个值都不在，比较大小
                return o1 - o2;
            }
        }).mapToInt(value -> value).toArray();

    }

    private static int[] sortByCount(int[] arr1, int[] arr2) {
        int upper = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > upper) upper = arr1[i];
        }

        int[] frequency = new int[upper + 1];

        for (int val : arr1) {
            frequency[val] = frequency[val] + 1;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        //遍历arr2部分，这部分在arr1中存在
        for (int val : arr2) {
            for (int i = 0; i < frequency[val]; i++) {
                result[index++] = val;
            }
            frequency[val] = 0;
        }

        //arr1存在，arr2不存在
        //从0  至 arr1最大值遍历一次，找出arr1存在，arr2不存在的值，置入result
        for (int x = 0; x <= upper; x++) {
            for (int j = 0; j < frequency[x]; j++) {
                result[index++] = x;
            }
        }

        return result;
    }
}
