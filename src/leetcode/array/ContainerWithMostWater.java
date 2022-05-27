package src.leetcode.array;

/**
 * @Author yan.zhang
 * @Date 2022/5/27 16:36
 * @Version 1.0
 */
public class ContainerWithMostWater {
    /**
     * https://leetcode.cn/problems/container-with-most-water/comments/
     * 最多盛水容器
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
