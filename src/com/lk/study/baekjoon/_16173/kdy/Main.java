package com.lk.study.baekjoon._16173.kdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>BFS > 16173 점프왕 쩰리(small)</h3>
 * <pre>
 * 레벨 - 실버4
 * 시간 - 23.03.21 19:25 ~ 20:00(35분 목표 / 20:44 1시간 19분 실패)
 *
 * 풀이 1 => 실패
 *  - 그래프를 잘못 받아 실패
 *
 * 풀이 2 => 실패
 *  - 방문처리 하지 않아 실패
 * </pre>
 */
public class Main {

    private boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var graph = new String[N][N];
        for (var i = 0; i < N; i++) {
            graph[i] = br.readLine().split(" ");
        }

        var self = new Main();
        System.out.println(self.findEnd(graph, N));
    }

    private String findEnd(String[][] graph, int N) {
        boolean[][] visits = new boolean[N][N];
        dfs(graph, visits, 0, 0);
        return isEnd ? "HaruHaru" : "Hing";
    }

    private void dfs(String[][] graph, boolean[][] visits, int x, int y) {
        visits[x][y] = true;
        if (isEnd) {
            return;
        }
        if ("-1".equals(graph[x][y])) {
            isEnd = true;
            return;
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        for (int i = 0; i < 2; i++) {
            var amount = Integer.parseInt(graph[x][y]);
            var mx = x + dx[i] * amount;
            var my = y + dy[i] * amount;

            if (mx >= graph.length || my >= graph[0].length) {
                continue;
            }
            if (visits[mx][my]) {
                continue;
            }
            dfs(graph, visits, mx, my);
        }
    }

}
