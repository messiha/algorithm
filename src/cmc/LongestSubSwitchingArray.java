package src.cmc;

/**
 * @author yan.zhang
 * @date 2023/8/9 13:37
 */
public class LongestSubSwitchingArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 3, 7, 2, 1, 2, 1, 2};
        int max = solution(arr);
        System.out.println(max);
    }

    public static int solution(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        int ans = 2;
        int temp = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] == A[i]) {
                temp = temp + 1;
            } else {
                temp = 2;
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
