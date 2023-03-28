package com.lk.study.baekjoon._16173.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 16173 백준
     * 시간 : 19:30 ~ 20:00
     * 결과 : 성공
     */
    private static boolean[][] visit;
    private static int[][] map;
    static int N;

    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        result = "Hing";
        StringTokenizer st;
        for( int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);

        System.out.println(result);
    }
    private static void dfs(int x, int y) {

        /*
         -1,-1 0,-1 1,-1
         -1, 0 0, 0 1, 0
         -1, 1 0, 1 1, 1
         */

        visit[x][y] = true;

        int move = map[x][y];

        int[] dx = {move, 0};
        int[] dy = {0, move};

        for (int i = 0; i < 2; i++) {
            if (move >= N) {
                continue;
            }
            int mx = x + dx[i];
            int my = y + dy[i];
            if ((0 <= mx && mx < N) && (0 <= my && my < N)) {
                if (visit[mx][my]) {
                    continue;
                }
                if (mx == (N-1) && my == (N-1)) {
                    result = "HaruHaru";
                    return;
                }
                dfs(mx,my);
            }
        }
    }
}
