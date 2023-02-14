package com.lk.study.baekjoon._1436.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>브루트포스 > 1436 영화감독 숌</h3>
 * <pre>
 * 레벨 - 실버5
 * 시간 - 23.02.14 19:25 ~ 20:10(45분 목표 / 19:41 16분 성공)
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var str = br.readLine();
        var N = Integer.parseInt(str);
        var self = new Main();
        System.out.println(self.getDoomsday(N));
    }

    private int getDoomsday(int N) {
        int i;
        for (i = 1; 0 < N; i++) {
            var str = Integer.toString(i);
            if (str.contains("666")) {
                N--;
            }
        }
        return i - 1;
    }

}
