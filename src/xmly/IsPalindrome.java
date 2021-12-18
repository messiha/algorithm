package src.xmly;

/**
 * @Author yan.zhang
 * @Date 2021/12/18 14:34
 * @Version 1.0
 */
public class IsPalindrome {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     */
    public static void main(String[] args) {
        int target = 101;
        System.out.println(decideByTransformStr(target));
        System.out.println(decideByTravel(target));
    }

    /**
     * 1.所有的负数都不是回文数
     * 2.反转后半部分，应该与前半部分相等。1221  21反转后为12
     *
     * @param target
     * @return
     */
    private static boolean decideByTravel(int target) {
        //最后一位为0,如果满足回文数条件，这个数字只能是0
        if (target < 0 || (target % 10 == 0 && target != 0)) {
            return false;
        }

        //记录已反转后的数
        int revertedNumber = 0;

        //整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，
        //当原始数字小于或等于反转后的数字时，说明已经处理了一半位数的数字了。
        while (target > revertedNumber) {
            revertedNumber = revertedNumber * 10 + target % 10;
            target = target / 10;
        }

        //当target长度为奇数时,由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        //比如121，revertedNumber=12 此时target = 1
        return target == revertedNumber || target == revertedNumber /10;

    }

    /**
     * 转换成字符串
     *
     * @param target
     * @return
     */
    private static boolean decideByTransformStr(int target) {
        String targetStr = String.valueOf(target);
        int low = 0;
        int high = targetStr.length() - 1;

        while (low != high && low < targetStr.length()) {
            if (targetStr.charAt(low) != targetStr.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }


}
