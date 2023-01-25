package com.lk.study.baekjoon._4673.kim;

/**
 * <h3>브루트포스 > 4673 셀프넘버</h3>
 * <pre>
 *  - 풀이시간: 23.01.25 22:27 ~ 22:44(27분 성공)
 * </pre>
 *
 * <a href="https://www.acmicpc.net/problem/4673">문제 링크</a>
 */
public class Main {
    public static void main(String[] args) {
        var isCalc = new boolean[10036];
        for (int i = 1; i <= 10000; i++) {
            if (!isCalc[i]) {
                System.out.println(i);
            }

            isCalc[calc(i)] = true;
        }
    }

    private static int calc(int n) {
        var sum = n;
        while (n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
