package src.off.array;

/**
 * @author yan.zhang
 * @date 2021/1/7 16:12
 */


public class FindDuplicate {
    /**
     * 在一个长度为n的数组里的所有数字都在0~n-1的范围内，某些数字重复，但是不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。例如，如果输入长度为7,的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数组2或者3。（n个元素，n种可能的取值）
     * <p>
     * 1.排序后查找
     * 2.hashMap解法
     * 3.数组中所有数字在0~n-1范围内，一共n个数，所以数据状况特殊，假设n=5，则数据在0~4范围内，所以数据情况一定是[0,1,2,3,4]
     * 排序后下标位置一定是数据的值，ag：下标为0的数字一定是0...
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 1, 0, 2, 5, 3};
        int duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }

    private static int findDuplicates(int[] arr) {
        int duplicate = -1;

        if (arr == null || arr.length == 0) {
            return duplicate;
        }

        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }

        return duplicate;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
