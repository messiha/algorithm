/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7;

/**
 * @author yan.zhang
 * @date 2020/1/26 21:48
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：某些项目需要占用会议室宣讲，会议室不能同时宣讲两个项目，給出每一个项目的开始时间和结束时间，安排宣讲日程
 * 要求会议室的宣讲场次最多，返回这个最多的场次
 * 思路:
 * 确定正确贪心策略
 * 1)根据会议开始时间，以最先开始为优先，错误
 * 2)根据会议持续时间优先，错误
 * 3)根据会议结束时间，以最先结束为优先，正确
 */
public class BestArrange {

    public static class Program {
        private int start;
        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= cur) { //淘汰不符合时间的项目安排
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
