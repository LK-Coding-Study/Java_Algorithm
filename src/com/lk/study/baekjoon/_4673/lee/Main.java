package com.lk.study.baekjoon._4673.lee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Number> a = new ArrayList<>();


        for (int i = 1; i<=10000; i++){
            int sum = i;
            int n = i;
            while (n >= 1) {
                sum += n % 10;
                n /= 10;
            }
            a.add(sum);
        }

        for(int j = 1; j<=10000; j++){
            if(!a.contains(j)){
                System.out.println(j);
            }
        }

    }
}
