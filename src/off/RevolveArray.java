/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2019/9/1 14:59
 */
public class RevolveArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * <p>
     * <p>
     * 思路：
     * 1.非递减排序，数组有序，且不是递减
     * 2.输入的为数据的旋转
     * 3.旋转后数组一部分递增，
     * arr[mid] 与 arr[right] 比较 如果arr[right]大,则说明 mid~right是顺序递增，则应该在left~mid范围查找
     */
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 8, 1, 2, 3};
//        int[] array = {10,9,8,5,11,12};
//        int[] array = {9, 10, 4, 5, 6};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            if (array[low] < array[high]) {
                return array[low];
            }
            int mid = (low + high) / 2;
            if (array[mid] > array[low]) {
                //mid 处于递增数组
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }

    private static int minNumber(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            } else if (array[mid] < array[high]) {
                //说明mid ~ high处在递增序列 需在low ~ mid-1范围寻找最小值
                high = mid - 1;
            } else {
                //说明low ~ mid 储在递增序列 需在mid+1 ~ high范围寻找最小值
                low = mid + 1;
            }

        }
        return 0;
    }
}
