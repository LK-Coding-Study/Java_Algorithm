package com.lk.study.baekjoon._1388.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>DFS > 1388 바닥장식</h3>
 * <pre>
 * 레벨 - 실버4
 * 시간 - 23.03.08 20:30 ~ 21:00(30분 목표 / 20:58 28분 성공)
 *
 * 풀이 1 => 실패
 *  - 현재 모양과 다음 모양만 비교하여 실패함.
 *
 * 풀이 2 => 성공
 *  - 시작 모양 기준 상하, 좌우 고정시켜 탐색
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var inputLine = br.readLine().split(" ");
        var N = Integer.parseInt(inputLine[0]);
        var M = Integer.parseInt(inputLine[1]);
        var graph = new char[N][M];
        for (var i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        var self = new Main();
        var visits = new boolean[N][M];
        var boardCount = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visits[x][y]) {
                    self.dfs(graph, visits, x, y);
                    boardCount++;
                }
            }
        }
        System.out.println(boardCount);
    }

    private void dfs(char[][] graph, boolean[][] visits, int x, int y) {
        // 하 상 우 좌
        var dx = new int[]{1, -1, 0, 0};
        var dy = new int[]{0, 0, 1, -1};

        visits[x][y] = true;
        var startD = graph[x][y] == '|' ? 0 : 2;
        for (int d = startD; d < startD + 2; d++) {
            var mx = x + dx[d];
            var my = y + dy[d];
            if (mx >= graph.length || mx < 0 || my >= graph[0].length || my < 0) {
                continue;
            }
            if (visits[mx][my]) {
                continue;
            }
            if (graph[x][y] != graph[mx][my]) {
                continue;
            }
            dfs(graph, visits, mx, my);
        }
    }

}
