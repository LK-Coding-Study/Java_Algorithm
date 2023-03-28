package com.lk.study.baekjoon._26169.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 26169 백준
     * 시간 : 19:15 ~ 20:00
     * 결과 :
     */

    private static boolean[][] visit;
    private static int[][] map;
    static int r, c, apple;
    static int move_count = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        map = new int[5][5];
        visit = new boolean[5][5];
        StringTokenizer st;
        for( int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if(map[r][c] == 1){
            apple++;
        }
        map[r][c] = -1;
        dfs(r,c, apple, 0);

        System.out.println(result);
    }
    private static void dfs(int r, int c, int apple, int move_count) {
        int temp = 0;
        /*
         -1,-1 0,-1 1,-1
         -1, 0 0, 0 1, 0
         -1, 1 0, 1 1, 1
         */
        if(move_count > 3){
            return;
        }
        if(apple >= 2){
            result = 1;
            return;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int mr = r + dx[i];
            int mc = c + dy[i];

            if ((0 <= mr && mr < 5) && (0 <= mc && mc < 5)) {
                if (map[mr][mc] == -1) {
                    continue;
                }
                if (visit[mr][mc]) {
                    continue;
                }
                visit[r][c] = true;
                dfs(mr, mc, map[mr][mc] == 1 ? (apple + 1) : apple, move_count+1);
                visit[r][c] = false;
            }

        }
    }
}
