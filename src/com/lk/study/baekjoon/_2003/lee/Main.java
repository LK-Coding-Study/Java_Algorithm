package com.lk.study.baekjoon._2003.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arrayA = br.readLine().split(" ");

        int count = 0;
        for(int i = 0; i < N; i++){
            if(numberSum(i,M, arrayA))
                count++;
        }

        System.out.println(count);

    }
    private static boolean numberSum(int i, int M, String[] arrayA){
        int sum = 0;
        for(int j = i; j < arrayA.length; j++){
            sum = sum + Integer.parseInt(arrayA[j]);
            if(sum == M)
                return true;
        }
        return false;
    }
}
