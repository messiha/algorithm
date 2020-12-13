/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/12/13 16:24
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 3, 2, 6, 7, 7};
        findNumsAppearOnce(arr, new int[1], new int[1]);


    }

    private static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }

        int count = 0;

        while (xor % 2 == 0) {
            xor = xor >> 1;
            count++;
        }

        int mask = 1 << count;
        //mask用来将数组划分成两部分

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & mask) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

   /* private static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>(8);

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        num1[0] = res.get(0);
        num2[0] = res.get(1);
    }*/


}
