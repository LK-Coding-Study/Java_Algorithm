package com.lk.study.baekjoon._1476.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>부루트포스 > 1476 날짜계산</h3>
 * <pre>
 * 레벨 - 실버 5
 * 시간 - 23.02.19 22:15 ~ 22:45(30분 목표 / 22:32 17분 성공)
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var ESM = br.readLine().split(" ");
        var E = Integer.parseInt(ESM[0]);
        var S = Integer.parseInt(ESM[1]);
        var M = Integer.parseInt(ESM[2]);

        var self = new Main();
        System.out.println(self.getYear(E, S, M));
    }

    private int getYear(int targetE, int targetS, int targetM) {
        int e = 1, s = 1, m = 1;
        int year = 1;
        while (e != targetE || s != targetS || m != targetM) {
            year++;
            e = nextNumber(e, 15);
            s = nextNumber(s, 28);
            m = nextNumber(m, 19);
        }
        return year;
    }

    private int nextNumber(int n, int maxNum) {
        n = (n + 1) % (maxNum + 1);
        return n == 0 ? 1 : n;
    }

}
