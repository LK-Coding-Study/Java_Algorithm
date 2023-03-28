package com.lk.study.baekjoon._26169.kdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h3>DFS > 26169 세 번 이내에 사과를 먹자</h3>
 * <pre>
 * 레벨 - 실버3
 * 시간 - 23.03.28 19:15 ~ 20:00(45분 목표 / 20:10 55분 실패)
 *
 * 풀이 1 => 실패
 *   - 지나온 길은 돌아오지 않는 점을 생각해 그래프에 직접 방문처리함.
 *   - 한번이라도 간 길은 탐색할 수 없어 실패
 *
 * 풀이 2 => 성공(시간 초과, 23.03.28 20:10 해결함)
 *   - 방문처리 변수 추가
 *   - 탐색 완료 후 돌아온 경우 방문처리 해제하여 다른 방향에서 탐색할 수 있도록 하여 성공
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var graph = new Integer[5][5];
        var visits = new boolean[5][5];
        for (var i = 0; i < 5; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        }
        var xy = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        var self = new Main();
        var isPossible = self.dfs(graph, visits, xy[0], xy[1], 0, 3);
        System.out.println(isPossible ? 1 : 0);
    }

    private boolean dfs(Integer[][] graph, boolean[][] visits, int x, int y, int appleCount, int remainCount) {
        if (appleCount >= 2) {
            return true;
        }
        if (remainCount == 0) {
            return false;
        }
        var dx = new int[]{1, -1, 0, 0};
        var dy = new int[]{0, 0, 1, -1};
        var isPossible = false;
        for (var i = 0; i < 4; i++) {
            var mx = x + dx[i];
            var my = y + dy[i];
            if (0 > mx || mx >= graph.length || 0 > my || my >= graph[0].length) {
                continue;
            }
            if (visits[mx][my]) {
                continue;
            }
            if (graph[mx][my] == -1) {
                continue;
            }
            visits[x][y] = true;
            isPossible |= dfs(graph, visits, mx, my,
                    graph[mx][my] == 1 ? appleCount + 1 : appleCount,
                    remainCount - 1);
            visits[x][y] = false;
        }
        return isPossible;
    }

}
