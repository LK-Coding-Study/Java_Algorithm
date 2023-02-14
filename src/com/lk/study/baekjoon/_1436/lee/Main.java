package com.lk.study.baekjoon._1436.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 : 666
2 : 1666
6 : 5666
7 : 6666
1부터 시작해서 666이 연속으로 된 숫자를 찾는데 그걸 순서대로 찾는다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int count  = 0;
        int movie_nm = 666;
        while(count != N){
            if(Integer.toString(movie_nm).contains("666")){
                count++;
            }
            movie_nm++;
        }
        System.out.println(--movie_nm);
    }
}
