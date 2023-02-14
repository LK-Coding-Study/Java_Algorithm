package com.lk.study.baekjoon._1065.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 각 자리수 나눈 후에 등차수열인지 확인
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int count = 99;

        if (N < 100) {
            System.out.println(N);
        } else {
            for (int i = 100; i <= N; i++) {
                if(checkNum(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    private static boolean checkNum(int num) {
        int[] arr = new int[4];

        int j;
        for (j = 0; j < 4 && num >= 1; j++) {
            arr[j] = num % 10;
            num /= 10;
        }
        int subNum = arr[0] - arr[1];
        /**
         * tobe : for (int k = 1; k < arr.length - 1; k++) {
         * 배열길이로 for문을 돌려 항상 4까지 진행
         */
        for (int k = 1; k < j - 1; k++) {
            if (arr[k] - arr[k + 1] != subNum)
                return false;
        }
        return true;
    }
}
