package com.lk.study.baekjoon._14501.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * <h3>브루트포스 > 14501 퇴사</h3>
 * <pre>
 * 레벨 - 실버3
 * 시간 - 23.02.28 20:00 ~ 20:45(45분 목표 / 22:00 2시간 실패)
 *
 * 풀이 1 => 실패
 *   - 완탐 + 메모이제이션으로 풀이
 *   - 날짜를 건너뛰어 일하는 경우를 생각하지 않아 실패
 *
 * 풀이 2 => 성공(시간 초과, 23.03.01 23:09 해결함)
 *   - bfs + 메모이제이션으로 해결
 *    1) 일한 다음 가능한 모든 날짜를 탐색해야함
 *    2) 일 시작가능한 날짜는 동일 depth 를 가져야 함.
 *    3) 너비우선탐색(bfs) 로 풀이
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var graph = new int[N + 1][N + 1];
        for (var i = 1; i <= N; i++) {
            var parsedLine = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            graph[i][0] = parsedLine.get(0);
            graph[i][1] = parsedLine.get(1);
        }

        var self = new Main();
        var maxProfit = 0;
        var memo = new int[N + 1];
        for (var d = 1; d <= N; d++) {
            maxProfit = Math.max(maxProfit, self.bfs(graph, N, memo, d));
        }
        System.out.println(maxProfit);
    }

    private int bfs(int[][] graph, int N, int[] memo, int startDay) {
        var que = new LinkedList<Integer>();
        que.add(startDay);
        var maxProfit = 0;
        while (!que.isEmpty()) {
            var day = que.poll();
            var profit = graph[day][1];
            var nextDay = day + graph[day][0];
            var profitSum = memo[day];
            if (nextDay == N + 1) {
                profitSum += profit;
            }
            maxProfit = Math.max(maxProfit, profitSum);
            for (var i = nextDay; i <= N; i++) {
                if (memo[i] < memo[day] + profit) {
                    memo[i] = memo[day] + profit;
                    que.add(i);
                }
            }
        }
        return maxProfit;
    }

}
