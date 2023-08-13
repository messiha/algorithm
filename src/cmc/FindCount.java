package src.cmc;

/**
 * @author yan.zhang
 * @date 2023/8/9 16:39
 */
public class FindCount {
    /**
     * Given a string str representing a number having N digits,
     * the task is to calculate the number of ways to make the given number divisible by 3 by changing at most one digit of the number.
     */
    public static void main(String[] args) {
        //ASCII表中'0'的ASCII码是48
        System.out.println(new Character('1') - 48);
        System.out.println(new Character('9') - 48);

        String ss = "23";
        findCount(ss);
    }

    private static void findCount(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); ++i) {
            sum += number.charAt(i) - 48;
        }
        int count = 0;
        if (sum % 3 == 0) {
            count++;
        }
        for (int i = 0; i < number.length(); i++) {
            int remain = sum - (number.charAt(i) - 48);
            for (int j = 0; j <= 9; j++) {
                //j != number.charAt(i) - 48 防止重复计算，比如"23", j取值不能为2
                if ((remain + j) % 3 == 0 && j != number.charAt(i) - 48) {
                    ++count;
                }
            }
        }
        System.out.println(count);
    }


}
