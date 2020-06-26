/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/30 21:42
 */

/**
 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友，请你试着想下,哪个小朋友会得到这份礼品呢？
 * (注：小朋友的编号是从0到n-1)
 * <p>
 * 题解:http://zhedahht.blog.163.com/blog/static/2541117420072250322938/
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(solutionBySimulate(10, 3));
    }

    /*
    种关系表示为：
    f(n,m)={  0     n=1
              [f(n-1,m)+m]%n     n>1
           }
     */
    private static int solutionBySimulate(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        if (n == 1) return 0;

        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
