package com.lk.study.baekjoon._14889.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * <h3>브루트포스 > 14889 스타트와 링크</h3>
 * <pre>
 * 레벨 - 실버2
 * 시간 - 23.02.21 19:31 ~ 20:31(1시간 목표 / 21:50 2시간 20분 실패)
 *
 * 풀이 1 => 실패
 *   - 시너지를 생각해 서로 짝이 지어지는 경우만 생각함(케이스1만 고려함)
 *   - N/2 = 홀수인 경우 짝이 이루어지지 않기 때문에 성립하지 않음
 *
 * 풀이 2 => 성공(시간 초과, 23.02.22 해결함)
 *   - N/2 명 골라서 한쪽에 배치한 다음 서로 차이를 구한다.
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var graph = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            var line = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
        var self = new Main();
        System.out.println(self.pickNumbers(N, graph));
    }

    private int pickNumbers(int N, int[][] graph) {
        var minSum = -1;
        var visits = new boolean[N + 1];
        var stack = new Stack<Integer>();
        for (int i = 1; i < N + 1; i++) {
            stack.push(i);
            visits[i] = true;
            var idx = i;
            while (!stack.empty()) {
                if (stack.size() == N/2) {
                    var divSum = sumStat(N, graph, visits);
                    minSum = minSum == -1 ? divSum : Math.min(minSum, divSum);
                    idx = stack.pop();
                    visits[idx] = false;
                    continue;
                }
                if (idx == N) {
                    idx = stack.pop();
                    visits[idx] = false;
                    continue;
                }
                idx++;
                stack.push(idx);
                visits[idx] = true;
            }
        }
        return minSum;
    }

    private int sumStat(int N, int[][] graph, boolean[] visits) {
        var startSum = 0;
        var linkSum = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (visits[i] && visits[j]) {
                    startSum += (graph[i][j] + graph[j][i]);
                } else if (!visits[i] && !visits[j]) {
                    linkSum += (graph[i][j] + graph[j][i]);
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }

}
