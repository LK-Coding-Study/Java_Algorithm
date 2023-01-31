package com.lk.study.baekjoon._1065.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>브루트포스 > 1065 한수</h3>
 * <pre>
 * 레벨 - 실버4
 * 시간 - 23.01.30 22:05 ~ 22:35(30분 성공)
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var str = br.readLine();
        var N = Integer.parseInt(str);

        // 1. N < 100
        if (N < 100) {
            System.out.println(N);
            return;
        }

        var count = 99;
        for (int i = 100; i <= N; i++) {
            if (isOneNumber(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isOneNumber(int number) {
        // 1. 나눠서 배열에 저장
        var arr = new int[4]; // 최대 1000 -> 4자리
        var idx = 0;
        for (idx = 0; number > 0 && idx < 4; idx++) {
            arr[idx] = number % 10;
            number /= 10;
        }

        // 2. 배열 순차탐색
        var subVal = arr[0] - arr[1];
        for (var i = 1; i < idx - 1; i++) {
            if (arr[i] - arr[i+1] != subVal) {
                return false;
            }
        }

        return true;
    }

}
