package com.lk.study.baekjoon._1018.kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>부루트포스 > 1018 체스판 다시 칠하기[실버 4]</h3>
 * 풀이시간: 23.01.31 23:38 ~ 24:08(30분 성공)
 *
 * <pre>
 *  <b>풀이방법</b>
 *   1. 8*8 선택
 *   2. 하나의 색 기준 선택(이하 흰색 기준으로 설명)
 *   3. 흰색 변경여부 확인
 *     - 흰색 변경 O -> 검은색 변경 X
 *     - 흰색 변경 X -> 검은색 변경 O
 *
 *  <b>풀이기록</b>
 *   1. 8*8 자르는 범위 오류로 실패
 *   2. 행 변경 시 기준 색을 변경하지 않아 실패
 *   3. 성공
 * </pre>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var arr = br.readLine().split(" ");
        var N = Integer.parseInt(arr[0]);
        var M = Integer.parseInt(arr[1]);

        var graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        var minChangeCount = 50 * 50; // 50*50 행렬기준 최댓값 설정 -> 전부 바뀌는 경우는 없음.(하나도 바뀌지 않는 경우와 동일하기 때문)
        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                minChangeCount = Math.min(minChangeCount, changeColorCount(graph, x, y));
            }
        }
        System.out.println(minChangeCount);
    }

    private static int changeColorCount(char[][] graph, int sx, int sy) {
        var isWhiteOrder = true;
        var whiteBaseCount = 0;
        var blackBaseCount = 0;

        // 흰색 기준 -> 바뀌지 않는 경우는 검은색 기준으로는 바뀐다.
        for (int x = sx; x < sx + 8; x++) {
            for (int y = sy; y < sy + 8; y++) {
                var color = graph[x][y];
                if ((isWhiteOrder && color == 'B') || (!isWhiteOrder && color == 'W')) {
                    whiteBaseCount++;
                } else {
                    blackBaseCount++;
                }
                isWhiteOrder = !isWhiteOrder;
            }
            isWhiteOrder = !isWhiteOrder; // 행 변경 시, 한번더 체인지
        }
        return Math.min(whiteBaseCount, blackBaseCount);
    }

}
