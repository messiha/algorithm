package src.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/5/21 17:08
 * @Version 1.0
 */
public class BitMap {
    private static final int N = 10000000;
    private int[] a = new int[N / 32 + 1];

    /** * 设置所在的bit位为1 * * @param n */
    public void addValue(int n) {
        //n模上32至关于n向右移动5位
        int row = n >> 5;
        //将1左移n%32位，且与自身或运算，保持以前存储的数据不变。
        a[row] |= 1 << n;
    }

    // 判断所在的bit为是否为1
    public boolean exits(int n) {
        int row = n >> 5;
        return (a[row] & 1 << n) != 0;
    }

    public void display(int row) {
        System.out.println("BitMap位图展现");
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int temp = a[i];
            for (int j = 0; j < 32; j++) {
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a[" + i + "]" + list);
        }
    }

    public static void main(String[] args) {
        int num[] = {1, 5, 30, 32, 64, 56, 159, 120, 21, 17, 35, 45};
        BitMap map = new BitMap();
        for (int i = 0; i < num.length; i++) {
            map.addValue(num[i]);
        }

        int temp = 5;
        if (map.exits(temp)) {
            System.out.println("temp:" + temp + "has already exists");
        }
        map.display(5);
    }
}
