package com.lk.study.baekjoon._7568.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>부루트포스 > 7568 덩치[실버 5]</h3>
 * 풀이시간: 23.01.30 23:13 ~ 24:27(1시간 14분) 실패
 * 해결시간: 23.01.30 23:13 ~ 23.01.31 01:26
 * <pre>
 *  해결과정
 *  1. 우선순위큐로 정렬 후 순위 계산 -> 실패
 *  2. 본인보다 큰 사람 수 +1로 계산(완전탐색) -> 성공
 *
 *  문제에 덩치 큰 사람 + 1 이 등수라고 표시되어있음에도 우선순위큐로
 *  억지로 풀어서 실패함... 문제를 꼼꼼히 읽고 풀자
 * </pre>
 *
 */
public class Main {

    static class People {
        final int x;
        final int y;

        int higherCount;

        public People(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
            this.higherCount = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var peoples = new People[N];
        for (int i = 0; i < N; i++) {
            var xy = br.readLine().split(" ");
            peoples[i] = new People(xy[0], xy[1]);
        }
        calcRanks(peoples);
        printRankArray(peoples);
    }

    private static void calcRanks(People[] peoples) {
        for (int i = 0; i < peoples.length; i++) {
            var target = peoples[i];
            // 우선순위큐로 정렬했음에도 틀림 -> 전체 완탐으로 수정
            for (int j = 0; j < peoples.length; j++) {
                if (i == j) {
                    continue; // 본인 제외
                }
                var people = peoples[j];
                if (target.x < people.x && target.y < people.y) {
                    target.higherCount++;
                }
            }
        }
    }

    private static void printRankArray(People[] peoples) {
        var sb = new StringBuilder();
        for (var people : peoples) {
            sb.append(people.higherCount + 1).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
