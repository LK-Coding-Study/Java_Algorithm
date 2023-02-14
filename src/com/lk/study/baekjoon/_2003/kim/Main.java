package com.lk.study.baekjoon._2003.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>브루트포스 > 2003 수들의 합 2</h3>
 * <pre>
 * 레벨 - 실버4
 * 시간 - 23.02.14 20:32 ~ 21:10(38분 목표 / 21:05 33분 성공)
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var arr = br.readLine().split(" ");
        var N = Integer.parseInt(arr[0]);
        var M = Integer.parseInt(arr[1]);
        var A = br.readLine().split(" ");

        var self = new Main();
        System.out.println(self.getSumNumberCount(A, N, M));
    }

    private int getSumNumberCount(String[] A, int N, int M) {
        var sumCount = 0;
        for (int i = 0; i < N; i++) {
            var sum = 0;
            for (int j = i; j < N; j++) {
                sum += Integer.parseInt(A[j]);
                if (sum == M) {
                    sumCount++;
                    break;
                } else if (sum > M) {
                    break;
                }
            }
        }

        return sumCount;
    }

}
