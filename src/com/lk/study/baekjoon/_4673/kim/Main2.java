package com.lk.study.baekjoon._4673.kim;

public class Main2 {

    public static void main(String[] args) {
        boolean[] memo = new boolean[20000];

        for (int i = 1; i <= 10000; i++) {
            int sum = i;
            int n = i;
            while (n >= 1) {
                sum += n % 10;
                n /= 10;
            }
            memo[sum] = true;
            if (!memo[i]) {
                System.out.println(i);
            }
        }
    }

}
